package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员后台登录
 * Created by nilme on 2017/1/4.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/test")
    @RequiresPermissions("admin")
    public String logout() {
        return "admin/index";
    }





}
