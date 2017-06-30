package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.api.ApiCartDTO;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/29.
 */
public interface CartService {


    /**
     * 购物车商品列表
     * @param page
     * @param pageSize
     * @return
     */
    ArrayList<ApiCartDTO> getCartList(Integer page, Integer pageSize);

    /**
     * 购物车移除商品
     * @param cartId
     * @return
     */
    int deleteCartGoods(Integer cartId);

    /**
     * 添加购物车商品
     *
     * @param goodsId
     * @param goodsSkuId
     * @param goodsNum
     * @return
     */
    int addCartGoods(Integer goodsId, Integer goodsSkuId, Integer goodsNum);

    /**
     * 购物车更新商品数量
     * @param cartId
     * @param goodsNum
     * @return
     */
    int updateCartGoods(Integer cartId, Integer goodsNum);

    /**
     * 删除购物车商品
     * @param goodsId
     * @return
     */
    int deleteCartGoodsByGoodsId(Integer goodsId);
}
