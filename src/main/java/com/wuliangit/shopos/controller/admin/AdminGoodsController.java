package com.wuliangit.shopos.controller.admin;

import org.springframework.stereotype.Controller;
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
    public String addPage(){

        return "admin/goods/add";
    }


}
