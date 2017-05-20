package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.exception.OptionException;

import java.util.List;

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

    /**
     * 获取商品评价
     *
     * @param page
     * @param pageSize
     *@param goodsId  @return
     */
    List<ApiEvaluateGoodsListDTO> getEvaluateGoodsList(Integer page, Integer pageSize, Integer goodsId);
}
