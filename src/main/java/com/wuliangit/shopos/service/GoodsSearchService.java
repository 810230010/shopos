package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.api.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.GoodsSearchDTO;

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
     * @param lng
     *@param lat @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page,
                                              Integer pageSize,
                                              String searchKey,
                                              String orderType,
                                              Integer brandId,
                                              Integer goodsCategoryId,
                                              Integer storeId,
                                              Integer storeGoodsCategoryId, String type, Double lng, Double lat,
                                              Integer activityId);

    /**
     * 企业直销商品专区
     * @param goodsSearchDTO
     * @return
     */
    ArrayList<ApiGoodsListDTO> directSellingSearch(GoodsSearchDTO goodsSearchDTO);

    /**
     * 企业新品商品专区
     * @param goodsSearchDTO
     * @return
     */
    ArrayList<ApiGoodsListDTO> newGoodsSearch(GoodsSearchDTO goodsSearchDTO);

    /**
     * 企业活动商品专区
     * @param goodsSearchDTO
     * @return
     */
    ArrayList<ApiGoodsListDTO> activityGoodsSearch(GoodsSearchDTO goodsSearchDTO);

    /**
     * 一口秒价专区
     * @param goodsSearchDTO
     * @return
     */
    ArrayList<ApiGoodsListDTO> seckillGoodsSearch(GoodsSearchDTO goodsSearchDTO);


    /**
     * 普通商品专区
     * @param goodsSearchDTO
     * @return
     */
    ArrayList<ApiGoodsListDTO> normalGoodsSearch(GoodsSearchDTO goodsSearchDTO);

    /**
     * 首页商品
     * @return
     */
    ArrayList<ApiGoodsListDTO> indexGoods();

    /**
     * 二手商品
     * @param goodsSearchDTO
     * @return
     */
    ArrayList<ApiGoodsListDTO> secondHandSearch(GoodsSearchDTO goodsSearchDTO);
}
