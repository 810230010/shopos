package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/6/3.
 */
public interface GoodsSearchMapper {

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
