package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nilme on 2017/4/10.
 */

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

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
    @ResponseBody
    public Object add(Goods goods,String skuStr){
        RestResult result = new RestResult();

        int res = goodsService.createGoods(goods,skuStr);

        return result;
    }

}
