package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Order;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order, Integer> {

    /**
     * 获取合并的订单
     * @param outTradeNo
     * @return
     */
    List<Order> getOrderByOutTradeNoMerge(String outTradeNo);

    /**
     * 获取当个订单
     * @param outTradeNo
     * @return
     */
    Order getOrderByOutTradeNo(String outTradeNo);
}