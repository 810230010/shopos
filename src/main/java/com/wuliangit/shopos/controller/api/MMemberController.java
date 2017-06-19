package com.wuliangit.shopos.controller.api;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.common.model.RegisterInfo;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.cache.SpringCacheManager;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.im.JpushIM;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.ApiMemberDTO;
import com.wuliangit.shopos.dto.ApiMemberUpdateDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.SMSService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.Cache;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.wuliangit.shopos.common.CoreConstants.SESSION_CURRENT_USERID;

/**
 * 用户相关接口
 * Created by nilme on 2017/3/15.
 */

@RestController
@RequestMapping("/api/v1/member")
public class MMemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private SMSService smsService;
    @Autowired
    private SpringCacheManager springCacheManager;
    @Autowired
    private Mapper mapper;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private StoreService storeService;

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestParam(required = true) String username,
                        @RequestParam(required = true) String password) {
        RestResult restResult = new RestResult();
        String error = null;
        try {
            SecurityUtils.getSubject().login(new UserToken(username, password, UserToken.UserType.MEMBER, UserToken.LoginType.TOKEN));
            Member user = memberService.getByUsername(username);
            String token = tokenManager.createToken(user.getMemberId());
            tokenManager.createTokenData(token, user);

            restResult.add("token", token);
            restResult.add("userId", user.getMemberId());
            restResult.add("IMPassword",user.getImPassword());

            return restResult;
        } catch (UnknownAccountException e) {
            error = "用户不存在";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            e.printStackTrace();
            error = "密码重试超过5次，请10分钟后再试";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            error = "用户名/密码错误";
        } catch (Exception e) {
            e.printStackTrace();
            error = "其他错误：" + e.getMessage();
        }
        restResult.setCode(RestResult.CODE_SERVERERROR);
        restResult.setMsg(error);
        return restResult;
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("/logout")
    public Object logout() {
        RestResult result = new RestResult();
        SecurityUtils.getSubject().logout();
        return result;
    }


    /**
     * 注册获取验证码
     *
     * @param phone
     * @return
     */
    @RequestMapping("/register/getCode")
    public Object getRegisterCode(String phone) {
        RestResult result = new RestResult();
        Member byUsername = memberService.getByUsername(phone);
        if (byUsername != null) {
            result.setCode(202);
            result.setMsg("该手机已经被注册");
            return result;
        }

        boolean b = smsService.sendRegisterCode(phone);
        if (b) {
            return result;
        } else {
            result.setCode(RestResult.CODE_SERVERERROR);
            result.setMsg("短信获取失败，您的请求可能过于频繁");
            return result;
        }
    }

    /**
     * 注册短信验证码验证
     *
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping("/register/codeCheck")
    public Object getRegisterCodeCheck(String phone, String code) {
        RestResult result = new RestResult();
        String checkCode = smsService.getCheckCode(phone);
        if (code.equals(checkCode)) {
            return result;
        } else {
            result.setCode(RestResult.CODE_SERVERERROR);
            result.setMsg("验证码错误");
            return result;
        }
    }

    /**
     * 用户注册
     *
     * @param phone
     * @param password
     * @param code
     * @return
     */
    @RequestMapping("/register")
    public Object register(@RequestParam(required = true) String phone,
                           @RequestParam(required = true) String password,
                           @RequestParam(required = true) String code) throws APIConnectionException, APIRequestException {
        RestResult result = new RestResult();

        Member byUsername = memberService.getByUsername(phone);
        if (byUsername != null) {
            result.setCode(202);
            result.setMsg("该手机已经被注册");
            return result;
        }

        String checkCode = smsService.getCheckCode(phone);
        if (code.equals(checkCode)) {
            Member member = new Member();
            member.setCreateTime(new Date());
            member.setUpdateTime(new Date());
            member.setUsername(phone);
            member.setNickname(phone);
            member.setMobile(phone);
            member.setType(POJOConstants.USER_TYPE_DEFAULT);
            member.setAuthState(POJOConstants.NOT_AUTH);
            member.setSalt(PasswordHelper.generateSalt());
            member.setPassword(PasswordHelper.generatePassword(password, member.getSalt()));
            //设置默认头像
            member.setPhoto("http://ooa95t7wi.bkt.clouddn.com/default-header.png");

            member.setImPassword(this.getRandomCode());
            //注册极光推送IM
            List<RegisterInfo> registerInfos = new ArrayList<>();
            RegisterInfo registerInfo = RegisterInfo.newBuilder().setPassword(member.getImPassword()).setUsername(member.getUsername()).build();
            registerInfos.add(registerInfo);
            String s = JpushIM.getClient().registerUsers(registerInfos.toArray(new RegisterInfo[registerInfos.size()]));

            memberService.createMember(member);

        } else {
            result.setCode(RestResult.CODE_BUSINESS_ERROR);
            result.setMsg("验证码错误");
        }

        return result;
    }

    /**
     * 更新密码
     *
     * @param newpass
     * @param code
     * @return
     */
    @RequestMapping("/repass")
    public Object repass(String newpass, String code, Integer userId) {
        RestResult result = new RestResult();
        Member member = WebUtil.getCurrentMember();
        Cache<Object, Object> cache = springCacheManager.getCache("sms-session");
        String cacheCode = (String) cache.get(member.getUsername());
        if (cacheCode.equals(code)) {
//            member.setSalt(PasswordHelper.generateSalt());//salt不更新，后面还有支付密码也会用到这个salt
            member.setPassword(PasswordHelper.generatePassword(newpass, member.getSalt()));
            memberService.updateMember(member);
            result.setMsg("密码更新成功");
        } else {
            result.setCode(RestResult.CODE_BUSINESS_ERROR);
            result.setMsg("验证码错误");
        }

        return result;
    }

    /**
     * 修改密码获取验证码
     *
     * @param phone
     * @return
     */
    @RequestMapping("/repass/getCode")
    public Object getRepassCode(String phone) {
        RestResult result = new RestResult();
        boolean res = smsService.sendtRepassCode(phone);
        if (res) {
            return result;
        } else {
            result.setCode(RestResult.CODE_SERVERERROR);
            result.setMsg("修改面密码验证码获取失败，请重试！");
            return result;
        }
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/info")
    public Object getUserInfo() {
        RestResult result = new RestResult();
        Member member = memberService.getByMemberId(WebUtil.getCurrentMember().getMemberId());

        if (!StringUtils.isEmpty(member.getPhoto())) {
            member.setPhoto(member.getPhoto() + "-apiPhotoResize");
        }

        ApiMemberDTO memberDTO = mapper.map(member, ApiMemberDTO.class);
        result.add("memberInfo", memberDTO);
        result.add("bindStore",storeService.getSellerInfo());
        return result;
    }

    /**
     * 更新用户信息
     *
     * @param member 会员信息
     * @return
     */
    @RequestMapping("/info/update")
    public Object updateUserInfo(ApiMemberUpdateDTO member) {
        RestResult result = new RestResult();

        //头像更新处理
        if (member.getPhoto() != null && !member.getPhoto().equals("")) {
            member.setPhoto(QiNiuUtils.getBaseUrl() + member.getPhoto());
        }

        Member memberUpdate = WebUtil.getCurrentMember();
        mapper.map(member, memberUpdate);
        memberService.updateMember(memberUpdate);
        return result;
    }

    /**
     * 提交认证资料
     *
     * @param truename
     * @param idcardNum
     * @return
     */
    @RequestMapping("authenticate")
    public Object Authenticate(String truename, String idcardNum, String idcardFront, String idcardBack) {
        RestResult result = new RestResult();

        Member memberUpdate = WebUtil.getCurrentMember();
        memberUpdate.setIdcardNum(idcardNum);
        memberUpdate.setTruename(truename);
        memberUpdate.setIdcardBack(QiNiuUtils.getBaseUrl() + idcardBack);
        memberUpdate.setIdcardFront(QiNiuUtils.getBaseUrl() + idcardFront);
        memberUpdate.setAuthState(POJOConstants.WAIT_AUTH);

        memberService.updateMember(memberUpdate);
        return result;
    }

    @RequestMapping("uploadGPS")
    public Object uploadGPS(Double longitude, Double latitude){
        RestResult result = new RestResult();

        int res = memberService.uploadGPS(longitude,latitude);

        return result;
    }

    /**
     * 获取6位随机密码
     * @return
     */
    private String getRandomCode(){
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        int code = tmp % (999999 - 100000 + 1) + 100000;
        return  code+"";
    }

}
