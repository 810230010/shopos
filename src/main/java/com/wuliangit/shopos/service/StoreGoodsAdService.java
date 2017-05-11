package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.StoreGoodsAd;

import java.util.List;

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

    /**
     * @Description: 获取已有广告的商品信息
     * @Author: pangweichao
     * @Date: 14:46 2017/5/11
     * @Param: [searchKey, orderColumn, orderType, page, pageSize, storeId]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreGoodsDetailDTO>
     */
    List<StoreGoodsDetailDTO> getStoreGoodsWithAd(String searchKey, String orderColumn,String orderType,Integer page,Integer pageSize, Integer storeId);

    /**
     * @Description: 获取没有广告的商品信息
     * @Author: pangweichao
     * @Date: 14:46 2017/5/11
     * @Param: [storeId]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreGoodsDetailDTO>
     */
    List<StoreGoodsDetailDTO> getStoreGoodsWithoutAd(Integer storeId);

}
