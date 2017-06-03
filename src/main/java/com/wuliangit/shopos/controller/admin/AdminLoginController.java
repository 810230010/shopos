package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.UserRealm;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.AdminService;
import com.wuliangit.shopos.service.AdminPermissionService;
import com.wuliangit.shopos.service.AnalyzeService;
import com.wuliangit.shopos.service.SellerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 管理员后台登录
 * Created by nilme on 2017/1/4.
 */

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    private static Log logger = LogFactory.getLog(AdminLoginController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private AdminPermissionService adminPermissionService;
    @Autowired
    private AnalyzeService analyzeService;

    @RequestMapping("/index")
    public String viewToIndex(Model model) {
        model.addAttribute("statistic", analyzeService.adminAnalyzeAllStore());
        return "admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username, String password) {
        String error = null;
        try {
            SecurityUtils.getSubject().login(new UserToken(username, password, UserToken.UserType.ADMIN, UserToken.LoginType.ADMIN));

            Admin admin = adminService.getByUsername(username);
            WebUtil.getSession().setAttribute(CoreConstants.SESSION_CURRENT_ADMIN, admin);

            Seller seller = sellerService.getById(0);
            WebUtil.getSession().setAttribute(CoreConstants.SESSION_CURRENT_SELLER, seller);

            List<MenuDTO> menus = adminPermissionService.getAdminMenus();
            WebUtil.getSession().setAttribute(CoreConstants.SESSION_CURRENT_MENU, menus);
            return "redirect:/admin/index";
        } catch (UnknownAccountException e) {
            error = "用户不存在";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            e.printStackTrace();
            error = "重试次数过多，请稍候再试";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            error = "用户名/密码错误";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            error = "系统错误";
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
        //登出清除缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm userRealm = (UserRealm)securityManager.getRealms().iterator().next();
        userRealm.clearAllCache();
        //登出
        SecurityUtils.getSubject().logout();
        return "redirect:admin/login";
    }

}
