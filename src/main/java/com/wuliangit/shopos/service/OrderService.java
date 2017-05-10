package com.wuliangit.shopos.service;

import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.OrderGoodsNum;

import java.math.BigDecimal;
import java.util.List;

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
    AlipayTradeAppPayModel createOrder(List<OrderGoodsNum> orderInfos, Integer addressId, String orderFrom, BigDecimal goodsAmount) throws OrderException;

}
