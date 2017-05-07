package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.GoodsAd;
import org.apache.ibatis.annotations.Param;

public interface GoodsAdMapper extends BaseMapper<GoodsAd , Integer> {

    /**
     * 获取商品广告图片
     * @param goodsId
     * @param storeId
     * @return
     */
    String getGoodsAdImg(@Param("goodsId") Integer goodsId,@Param("storeId") Integer storeId);

    /**
     * 更新商品广告
     * @param goodsId
     * @param storeId
     * @param img
     * @return
     * @throws Exception
     */
    Integer updateGoodsAd(@Param("goodsId") Integer goodsId,@Param("storeId") Integer storeId,@Param("img") String img);

}