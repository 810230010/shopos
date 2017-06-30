package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.dto.api.ApiGoodsListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/6/3.
 */
public interface GoodsSearchMapper {


    /**
     * 商品搜索
     * @param searchKey
     * @param order
     * @param brandId
     * @param goodsCategoryId
     * @param storeId
     * @param storeGoodsCategoryId
     * @param type
     * @param lng
     *@param lat @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(@Param("searchKey") String searchKey,
                                              @Param("order") String order,
                                              @Param("brandId") Integer brandId,
                                              @Param("goodsCategoryId") Integer goodsCategoryId,
                                              @Param("storeId") Integer storeId,
                                              @Param("storeGoodsCategoryId") Integer storeGoodsCategoryId,
                                              @Param("type") String type,
                                              @Param("lng")Double lng,
                                              @Param("lat")Double lat);

    /**
     * 商品类型专区
     * @param searchKey
     * @param order
     * @param type
     * @return
     */
    ArrayList<ApiGoodsListDTO> goodsTypeSearch(@Param("searchKey") String searchKey,
                                               @Param("order")String order,
                                               @Param("type")String type,
                                               @Param("lng")Double lng,
                                               @Param("lat")Double lat);

    /**
     * 首页商品
     * @return
     */
    ArrayList<ApiGoodsListDTO> indexGoods();
}
