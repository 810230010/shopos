package com.wuliangit.shopos.service;

/**
 * Created by 26229 on 2017/5/6.
 */
public interface GoodsAdService {

    /**
     * 获取商品的广告图片
     * @param goodsId
     * @param storeId
     * @return
     */
    String getGoodsAdImg(Integer goodsId, Integer storeId);

    /**
     * 更新商品广告
     * @param goodsId
     * @param storeId
     * @param img
     * @return
     * @throws Exception
     */
    Integer updateGoodsAd(Integer goodsId,Integer storeId, String img) throws  Exception;

    /**
     * 插入商品广告
     * @param storeId
     * @param goodsId
     * @param img
     * @return
     * @throws Exception
     */
    Integer insertGoodsAd(Integer storeId,Integer goodsId,String img) throws Exception;

}
