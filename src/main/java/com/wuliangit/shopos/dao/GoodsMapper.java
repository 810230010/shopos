package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiGoodsDTO;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.model.GoodsWithoutBody;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods, Integer> {

    /**
     * 商品搜索
     * @param searchKey
     * @param order
     * @param brandId
     * @param goodsCategoryId
     * @param storeId
     * @param storeGoodsCategoryId
     * @param type
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(@Param("searchKey") String searchKey,
                                              @Param("order") String order,
                                              @Param("brandId") Integer brandId,
                                              @Param("goodsCategoryId") Integer goodsCategoryId,
                                              @Param("storeId") Integer storeId,
                                              @Param("storeGoodsCategoryId") Integer storeGoodsCategoryId,
                                              @Param("type") String type);

    /**
     * 后台商品搜索
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<Goods> StoreSearch(@Param("storeId")Integer storeId,
                                 @Param("searchKey")String searchKey,
                            @Param("orderColumn")String orderColumn,
                            @Param("orderType")String orderType);

    /**
     * 不包行商品详情的商品对象
     * @param goodsId
     * @return
     */
    GoodsWithoutBody selectGoodsWithoutBodyByPrimaryKey(Integer goodsId);

    /**
     * 获取商品的简要信息
     * @param goodsId
     * @return
     */
    StoreGoodsDetailDTO getSimplGoodsInfo(Integer goodsId);

    /**
     * 通过店铺id获取店铺商品数量
     * @param storeId
     * @return
     */
    Integer getGoodsCountByStoreId(Integer storeId);

    /**
     * 接口获取商品详情
     * @param goodsId
     * @return
     */
    ApiGoodsDTO apiGetGoodsDTOById(Integer goodsId);
}