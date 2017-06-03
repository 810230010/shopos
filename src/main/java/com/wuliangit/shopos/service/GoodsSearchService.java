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
     * @param orderType                排序
     * @param brandId              品牌id
     * @param goodsCategoryId      商品分类id
     * @param storeId              店铺id
     * @param storeGoodsCategoryId 店铺内分类id
     * @param type                 商品类型
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page,
                                              Integer pageSize,
                                              String searchKey,
                                              String orderType,
                                              Integer brandId,
                                              Integer goodsCategoryId,
                                              Integer storeId,
                                              Integer storeGoodsCategoryId, String type);

    /**
     * 企业直销商品专区
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderType
     * @return
     */
    ArrayList<ApiGoodsListDTO> directSellingSearch(Integer page, Integer pageSize, String searchKey, String orderType);

    /**
     * 企业新品商品专区
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderType
     * @return
     */
    ArrayList<ApiGoodsListDTO> newGoodsSearch(Integer page, Integer pageSize, String searchKey, String orderType);

    /**
     * 企业活动商品专区
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderType
     * @return
     */
    ArrayList<ApiGoodsListDTO> activityGoodsSearch(Integer page, Integer pageSize, String searchKey, String orderType);

    /**
     * 一口秒价专区
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderType
     * @return
     */
    ArrayList<ApiGoodsListDTO> seckillGoodsSearch(Integer page, Integer pageSize, String searchKey, String orderType);


    /**
     * 普通商品专区
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderType
     * @return
     */
    ArrayList<ApiGoodsListDTO> normalGoodsSearch(Integer page, Integer pageSize, String searchKey, String orderType);

    /**
     * 首页商品
     * @return
     */
    ArrayList<ApiGoodsListDTO> indexGoods();
}
