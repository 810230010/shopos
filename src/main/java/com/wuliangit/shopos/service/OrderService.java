package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.OrderInfo;

import java.math.BigDecimal;

/**
 * Created by nilme on 2017/5/5.
 */
public interface OrderService {


    /**
     * 创建订单
     * @param orderInfos
     * @param addressId
     * @param orderFrom
     * @param goodsAmount
     * @return
     */
    Order createOrder(OrderInfo[] orderInfos, Integer addressId, String orderFrom, BigDecimal goodsAmount) throws OrderException;

}
