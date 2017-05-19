package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author boom
 * @description 卖家的相关操作
 * @create 2017-05-18 23:26
 **/
@Controller
@RequestMapping("/admin/seller")
public class AdminSellerController {

    @Autowired
    private SellerService sellerService;

    /**
     * @Description: 获取所有的卖家
     * @Author: pangweichao
     * @Date: 23:37 2017/5/18
     * @Param: []
     * @return: java.lang.Object
     */
    @RequestMapping("/getAllSeller")
    @ResponseBody
    public Object getAllSeller(){
        RestResult result = new RestResult();
        List<Seller> sellers = sellerService.getAllSeller();
        result.put("data",sellers);
        return result;
    }

}
