package com.wuliangit.shopos.service;

import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.OrderGoodsInfo;

import java.util.List;

/**
 * Created by nilme on 2017/5/5.
 */
public interface OrderService {


    /**
     * 创建订单
     * @param orderGoodsInfoList
     * @param addressId
     * @param orderFrom
     * @param orderMessage
     * @return
     * @throws OrderException
     */
    List<Order> ApiCreateOrder(List<OrderGoodsInfo> orderGoodsInfoList,Integer addressId, String orderFrom, String orderMessage) throws OrderException;

    /**
     * 通过id获取订单
     * @param orderId
     * @return
     */
    Order getOrderById(Integer orderId);

    /**
     * 更新订单信息
     * @param order
     * @return
     */
    int updateOrder(Order order);
}
