package com.wuliangit.shopos.controller.api;


import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MEvaluateGoodsController {

    @Autowired
    private EvaluateGoodsService evaluateGoodsService;

    /**
     *
     *创建评价
     * @param evaluateGoods
     * @return
     */
    @RequestMapping("/evaluate/goods/create")
    public Object createEvaluateGoods(ApiEvaluateGoodsDTO evaluateGoods) throws OptionException {
        RestResult result = new RestResult();
        int res = evaluateGoodsService.createEvaluateGoods(evaluateGoods);
        return result;
    }


    /**
     * 获取商品评价
     * @param page
     * @param pageSize
     * @param goodsId
     * @return
     */
    @RequestMapping("/public/goods/evaluates")
    public Object getEvaluateGoodsList(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            Integer goodsId) {
        RestResult result = new RestResult();
        List<ApiEvaluateGoodsListDTO> evaluateList = evaluateGoodsService.getEvaluateGoodsList(page, pageSize, goodsId);
        result.add("evaluateList", evaluateList);
        return result;
    }


}