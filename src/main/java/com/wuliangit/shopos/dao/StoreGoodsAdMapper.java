package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.StoreGoodsAd;
import org.apache.ibatis.annotations.Param;

public interface StoreGoodsAdMapper extends BaseMapper<StoreGoodsAd, Integer> {

    /**
     * 获取商品广告图片
     * @param goodsId
     * @param storeId
     * @return
     */
    String getStoreGoodsAdByStoreId(@Param("goodsId") Integer goodsId,@Param("storeId") Integer storeId);
}