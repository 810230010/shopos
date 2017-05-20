package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.entity.EvaluateGoods;

import java.util.List;

public interface EvaluateGoodsMapper extends BaseMapper<EvaluateGoods, Integer> {


    /**
     * 获取商品评价
     * @param goodsId
     * @return
     */
    List<EvaluateGoods> getEvaluateGoodsList(Integer goodsId);
}