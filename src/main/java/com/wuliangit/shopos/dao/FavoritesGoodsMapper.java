package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiCollectGoodsDTO;
import com.wuliangit.shopos.entity.FavoritesGoods;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 通过用户id和商品id获取用户商品收藏
     * @param memberId
     * @param goodsId
     * @return
     */
    FavoritesGoods getFavoritesGoodsByUserIdAndGoodsId(@Param("memberId")Integer memberId,  @Param("goodsId")Integer goodsId);
}