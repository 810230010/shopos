package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.GoodsSku;

import java.util.List;

public interface GoodsSkuMapper  extends BaseMapper<GoodsSku, Integer> {


    /**
     * 获取商品sku信息
     * @param goodsId
     * @return
     */
    List<GoodsSku> getGoodsSkuByGoodsId(Integer goodsId);
}