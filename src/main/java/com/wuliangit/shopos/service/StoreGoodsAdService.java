package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.StoreGoodsAd;

/**
 * Created by 26229 on 2017/5/6.
 */
public interface StoreGoodsAdService {

    /**
     * 获取商品的广告图片
     * @param goodsId
     * @param storeId
     * @return
     */
    String getGoodsAdImg(Integer goodsId, Integer storeId);

    /**
     * 更新商品广告
     * @param storeGoodsAd
     * @return
     * @throws Exception
     */
    Integer updateGoodsAd(StoreGoodsAd storeGoodsAd) throws  Exception;

    /**
     * 插入商品广告
     * @param storeGoodsAd
     * @return
     * @throws Exception
     */
    Integer insertGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception;

}
