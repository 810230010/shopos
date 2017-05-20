package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.exception.OptionException;

/**
 * Created by nilme on 2017/5/20.
 */
public interface EvaluateGoodsService {


    /**
     * 创建评价
     * @param evaluateGoods
     * @return
     */
    int createEvaluateGoods(ApiEvaluateGoodsDTO evaluateGoods) throws OptionException;
}
