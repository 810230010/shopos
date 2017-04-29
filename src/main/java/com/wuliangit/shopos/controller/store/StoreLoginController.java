package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 管理员后台登录
 * Created by nilme on 2017/1/4.
 */

@Controller
@RequestMapping("/store")
public class StoreLoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/index")
    public String viewToIndex(Model model) {
        return "store/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username, String password) {
        String error = null;
        try {
            SecurityUtils.getSubject().login(new UserToken(username, password, UserToken.UserType.STORE, UserToken.LoginType.STORE));

            Member member = memberService.getByUsername(username);
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, member);

            StoreUser storeUser = storeService.getStoreUser(member.getMemberId());
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_STORE, storeUser);

            return "redirect:/store/index";
        } catch (UnknownAccountException e) {
            error = "用户不存在";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            e.printStackTrace();
            error = "重试此时过多，请稍候再试";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            error = "用户名/密码错误";
        } catch (Exception e) {
            error = "其他错误：" + e.getMessage();
        }
        model.addAttribute("error", error);
        return "store/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "store/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:store/login";
    }





}
