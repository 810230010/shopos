package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.StoreGoodsAd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreGoodsAdMapper extends BaseMapper<StoreGoodsAd, Integer> {

    /**
     * 获取商品广告图片
     * @param goodsId
     * @param storeId
     * @return
     */
    String getStoreGoodsAdByStoreId(@Param("goodsId") Integer goodsId,@Param("storeId") Integer storeId);

    /**
     * @Description: 获取已有广告的商品信息
     * @Author: pangweichao
     * @Date: 14:46 2017/5/11
     * @Param: [searchKey, orderColumn, orderType, storeId]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreGoodsDetailDTO>
     */
    List<StoreGoodsDetailDTO> getStoreGoodsWithAd(@Param("searchKey") String searchKey,@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("storeId") Integer storeId);

    /**
     * @Description: 获取没有广告的商品信息
     * @Author: pangweichao
     * @Date: 14:46 2017/5/11
     * @Param: [storeId]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreGoodsDetailDTO>
     */
    List<StoreGoodsDetailDTO> getStoreGoodsWithoutAd(Integer storeId);

    /**
     * @Description: 更新商品广告
     * @Author: pangweichao
     * @Date: 15:56 2017/5/11
     * @Param: [storeGoodsAd]
     * @return: java.lang.Integer
     */
    Integer updateGoodsAd(StoreGoodsAd storeGoodsAd);

    /**
     * api接口获取店铺商品广告
     * @param storeId
     * @return
     */
    List<StoreGoodsAd> apiGetStoreGoodsAd(Integer storeId);
}