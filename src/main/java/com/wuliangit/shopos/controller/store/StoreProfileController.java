package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.SellerDTO;
import com.wuliangit.shopos.entity.Seller;
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
@RequestMapping("/store/profile")
public class StoreProfileController {

    @Autowired
    private SellerService sellerService;

    /**
     * 店铺用户信息界面
     * @param model
     * @return
     */
    @RequestMapping("")
    public String profilePage(Model model) {
        Seller currentSeller = WebUtil.getCurrentSeller();
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("seller",currentSeller);
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        return "store/profile";
    }

    /**
     * 店铺用户信息修改
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object updateProfile(SellerDTO seller,String newPass) {
        RestResult result = new RestResult();
        int res = sellerService.update(seller,newPass);
        return result;
    }


}
