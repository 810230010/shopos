package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.CartMapper;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.entity.Cart;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nilme on 2017/3/29.
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ArrayList<Cart> getCartList(Integer page, Integer pageSize) {
        Member user = WebUtil.getCurrentMember();
        PageHelper.startPage(page,pageSize);
        ArrayList<Cart> carts = cartMapper.getCartList(user.getMemberId());
        return carts;
    }

    @Override
    public int deleteCartGoods(Integer cartId) {
        return cartMapper.deleteByPrimaryKey(cartId);
    }

    @Override
    public int addCartGoods(Integer goodsId, Integer goodsSkuId, Integer goodsNum) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        Member user = WebUtil.getCurrentMember();
        Cart cart = new Cart();

        cart.setGoodsSkuId(goodsSkuId);
        cart.setStoreId(goods.getStoreId());
        cart.setStoreName(goods.getStoreName());
        cart.setMemberId(user.getMemberId());
        cart.setCreateTime(new Date());
        cart.setGoodsId(goodsId);
        cart.setGoodsName(goods.getName());
        cart.setGoodsNum(goodsNum);
        cart.setGoodsPrice(goods.getPrice());
        cart.setGoodsTitleImg(goods.getTitleImg());

        return cartMapper.insertSelective(cart);
    }

    @Override
    public int updateCartGoods(Integer cartId, Integer goodsNum) {
        Cart cart = cartMapper.selectByPrimaryKey(cartId);
        cart.setGoodsNum(goodsNum);
        return cartMapper.updateByPrimaryKeySelective(cart);
    }
}
