package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nilme on 2017/4/10.
 */

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @RequestMapping("/listPage")
    public String listPage(){
        return "admin/goods/list";
    }

    @RequestMapping("/addPage")
    public String addPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        return "admin/goods/add";
    }

    @RequestMapping("/add")
    public Object add(Integer category){
        RestResult result = new RestResult();
        System.out.println(category);
        return result;
    }


}
