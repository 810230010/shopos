package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

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
     * @param parentId
     * @return
     */
    ArrayList<Goods> search(@Param("searchKey")String searchKey,
                            @Param("orderColumn")String orderColumn,
                            @Param("orderType")String orderType,
                            @Param("parentId")Integer parentId);
}