package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.core.cache.SpringCacheManager;
import com.wuliangit.shopos.core.controller.RestResult;
import com.wuliangit.shopos.core.realm.UserToken;
import com.wuliangit.shopos.core.util.PasswordHelper;
import com.wuliangit.shopos.core.util.WebUtil;
import com.wuliangit.shopos.dto.MemberUpdateDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.SMSService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.Session;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
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

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String username, String password) {
        RestResult restResult = new RestResult();
        String error = null;
        try {
            SecurityUtils.getSubject().login(new UserToken(username, password, UserToken.UserType.MEMBER, UserToken.LoginType.APP));
            Session session = WebUtil.getSession();
            restResult.add("token", session.getId());
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
    @RequestMapping("/register/get-code")
    public Object getRegisterCode(String phone) {
        RestResult result = new RestResult();
        boolean b = smsService.sendRegisterCode(phone);
        if (b) {
            return result;
        } else {
            result.setCode(RestResult.CODE_SERVERERROR);
            result.setMsg("短信获取失败，请重试");
            return result;
        }
    }

    /**
     * 用户注册
     * @param phone
     * @param password
     * @param code
     * @return
     */
    @RequestMapping("/register")
    public Object register(String phone,String password,String code) {
        RestResult result = new RestResult();
        Cache<Object, Object> cache = springCacheManager.getCache("sms-session");
        String cacheCode = (String)cache.get(phone);
        if (cacheCode.equals(code)){

            Member member = new Member();
            member.setCreateTime(new Date());
            member.setUpdateTime(new Date());
            member.setUsername(phone);
            member.setMobile(phone);
            member.setType(POJOConstants.USER_TYPE_DEFAULT);
            member.setAuthState(POJOConstants.NOT_AUTH);
            member.setSalt(PasswordHelper.generateSalt());
            member.setPasswd(PasswordHelper.generatePassword(password,member.getSalt()));
            memberService.createMember(member);

        }else{
            result.setCode(RestResult.CODE_BUSINESS_ERROR);
            result.setMsg("验证码错误");
        }
        return result;
    }

    /**
     * 更新密码
     * @param newpass
     * @param code
     * @return
     */
    @RequestMapping("/repass")
    public Object repass(String newpass,String code){
        RestResult result = new RestResult();
        Member member = WebUtil.getCurrentMember();
        Cache<Object, Object> cache = springCacheManager.getCache("sms-session");
        String cacheCode = (String)cache.get(member.getUsername());
        if (cacheCode.equals(code)){
//            member.setSalt(PasswordHelper.generateSalt());//salt不更新，后面还有支付密码也会用到这个salt
            member.setPasswd(PasswordHelper.generatePassword(newpass,member.getSalt()));
            memberService.updateMember(member);
            result.setMsg("密码更新成功");
        }else{
            result.setCode(RestResult.CODE_BUSINESS_ERROR);
            result.setMsg("验证码错误");
        }

        return result;
    }

    /**
     * 修改密码获取验证码
     * @param phone
     * @return
     */
    @RequestMapping("/repass/get-code")
    public Object getRepassCode(String phone){
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
     * @return
     */
    @RequestMapping("/info")
    public Object getUserInfo(){
        RestResult result = new RestResult();
        Member member = WebUtil.getCurrentMember();
        result.put("memberInfo",member);


        // TODO
        return result;
    }

    /**
     * 更新用户信息
     * @param member 会员信息
     * @return
     */
    @RequestMapping("/info/update")
    public Object updateUserInfo(MemberUpdateDTO member){
        RestResult result = new RestResult();
        Member memberUpdate = WebUtil.getCurrentMember();
        mapper.map(member,memberUpdate);
        memberService.updateMember(memberUpdate);
        return result;
    }

    /**
     * 提交认证资料
     * @param truename
     * @param idcardNum
     * @return
     */
    @RequestMapping("authenticate")
    public Object Authenticate(String truename, String idcardNum){
        RestResult result = new RestResult();

        Member memberUpdate = WebUtil.getCurrentMember();
        memberUpdate.setIdcardNum(idcardNum);
        memberUpdate.setTruename(truename);
        memberUpdate.setAuthState(POJOConstants.WAIT_AUTH);

        memberService.updateMember(memberUpdate);
        return result;
    }


}
