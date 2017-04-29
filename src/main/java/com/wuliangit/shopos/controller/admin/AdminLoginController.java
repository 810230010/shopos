package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.AdminService;
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
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    public String viewToIndex(Model model) {
        return "admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username, String password) {
        String error = null;
        try {
            SecurityUtils.getSubject().login(new UserToken(username, password, UserToken.UserType.ADMIN, UserToken.LoginType.ADMIN));

            Admin admin = adminService.getByUsername(username);
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, admin);
            StoreUser storeUser = new StoreUser();
            storeUser.setStoreId(0);
            storeUser.setName("自营");
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_STORE, storeUser);

            return "redirect:/admin/index";
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
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "admin/login";
    }





}
