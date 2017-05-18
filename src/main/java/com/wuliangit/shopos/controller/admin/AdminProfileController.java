package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.dto.SellerDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.AdminService;
import com.wuliangit.shopos.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nilme on 2017/5/17.
 */

@Controller
@RequestMapping("/admin/profile")
public class AdminProfileController {

    @Autowired
    private AdminService adminService;

    /**
     * 店铺用户信息界面
     * @param model
     * @return
     */
    @RequestMapping("")
    public String profilePage(Model model) {
        Admin currentAdmin = WebUtil.getCurrentAdmin();
        model.addAttribute("admin",currentAdmin);
        return "admin/profile";
    }

    /**
     * 店铺用户信息修改界面
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object updateProfile(AdminDTO admin, String newPass) {
        RestResult result = new RestResult();
        int res = adminService.update(admin,newPass);
        return result;
    }


}
