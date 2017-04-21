package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;

import java.util.ArrayList;

/**
 * 搜索服务
 * Created by nilme on 2017/4/4.
 */
public interface GoodsSearchService {

    /**
     * @param page                 页码
     * @param pageSize             页大小
     * @param searchKey            搜索树关键词
     * @param order                排序
     * @param brandId              品牌id
     * @param goodsCategoryId      商品分类id
     * @param storeId              店铺id
     * @param storeGoodsCategoryId 店铺内分类id
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page,
                                              Integer pageSize,
                                              String searchKey,
                                              String order,
                                              Integer brandId,
                                              Integer goodsCategoryId,
                                              Integer storeId,
                                              Integer storeGoodsCategoryId);
}
