package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiCartDTO;
import com.wuliangit.shopos.entity.Cart;

import java.util.ArrayList;

public interface CartMapper extends BaseMapper<Cart, Integer> {
    /**
     * 购物车商品列表
     * @param memberId
     * @return
     */
    ArrayList<ApiCartDTO> getCartList(Integer memberId);
}