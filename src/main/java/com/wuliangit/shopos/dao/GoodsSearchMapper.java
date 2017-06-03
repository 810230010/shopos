package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;

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
    ArrayList<ApiGoodsListDTO> goodsTypeSearch(String searchKey, String order, String type);
}
