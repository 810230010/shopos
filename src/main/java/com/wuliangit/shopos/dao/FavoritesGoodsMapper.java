package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiCollectGoodsDTO;
import com.wuliangit.shopos.entity.FavoritesGoods;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface FavoritesGoodsMapper extends BaseMapper<FavoritesGoods, Integer> {

    /**
     * 用户收藏商品列表
     *
     * @param memberId
     * @return
     */
    ArrayList<ApiCollectGoodsDTO> getCollectGoodsList(Integer memberId);

    /**
     * 删除收藏商品
     *
     * @param goodsId
     * @param memberId
     * @return
     */
    int deleteCollectGoods(@Param("goodsId") Integer goodsId, @Param("memberId") Integer memberId);
}