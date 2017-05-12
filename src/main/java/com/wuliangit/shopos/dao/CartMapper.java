package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiCartDTO;
import com.wuliangit.shopos.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface CartMapper extends BaseMapper<Cart, Integer> {
    /**
     * 购物车商品列表
     * @param memberId
     * @return
     */
    ArrayList<ApiCartDTO> getCartList(Integer memberId);

    /**
     * 获取用户加如过购物车的商品
     * @param memberId
     * @param goodsSkuId
     * @return
     */
    Cart getCartByMemberIdAndGoodsSkuId(@Param("memberId") Integer memberId, @Param("goodsSkuId")Integer goodsSkuId);
}