package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
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
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(@Param("searchKey") String searchKey,
                                              @Param("order") String order,
                                              @Param("brandId") Integer brandId,
                                              @Param("goodsCategoryId") Integer goodsCategoryId,
                                              @Param("storeId") Integer storeId,
                                              @Param("storeGoodsCategoryId") Integer storeGoodsCategoryId);
}