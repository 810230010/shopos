package com.wuliangit.shopos.controller.api;


import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/evaluate/goods")
public class MEvaluateGoodsController {

    @Autowired
    private EvaluateGoodsService evaluateGoodsService;

    /**
     * 创建评价
     *
     * @param evaluateGoods
     * @return
     */
    @RequestMapping("/create")
    public Object createEvaluateGoods(ApiEvaluateGoodsDTO evaluateGoods) throws OptionException {
        RestResult result = new RestResult();
        int res = evaluateGoodsService.createEvaluateGoods(evaluateGoods);
        return result;
    }


}