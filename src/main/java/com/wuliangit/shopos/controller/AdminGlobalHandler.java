package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.Admin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台管理界面异常捕获
 */
@ControllerAdvice(basePackages = "com.wuliangit.shopos.controller.admin")
public class AdminGlobalHandler {

    private static Log logger = LogFactory.getLog(AdminGlobalHandler.class);

    @ModelAttribute("admin")
    public Admin setUser() {
        Admin admin = WebUtil.getCurrentAdmin();
        return admin;
    }

    @ModelAttribute("menus")
    public List<MenuDTO>  setMenus() {
        List<MenuDTO> menus = (List<MenuDTO>)WebUtil.getSession().getAttribute(CoreConstants.SESSION_CURRENT_MENU);
        return menus;
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public String errorHandlerOverJson(HttpServletRequest request, ResourceNotFoundException exception) {
        return "500";
    }

    @ExceptionHandler(value = Exception.class)
    public String errorHandlerOverJson(HttpServletRequest request, Exception exception) {
        logger.error(exception.getLocalizedMessage());
        exception.printStackTrace();
        return "500";
    }

}