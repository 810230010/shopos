package com.wuliangit.shopos.controller.api;


import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/evaluate/goods")
public class MEvaluateGoodsController {

    @Autowired
    private EvaluateGoodsService evaluateGoodsService;

    @RequestMapping("/create")
    public Object createEvaluateGoods(){
        RestResult result = new RestResult();

//        evaluateGoodsService.

        return result;
    }


}