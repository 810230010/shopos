package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
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

    /**
     * @Description: 商铺获取订单列表数据
     * @Author: pangweichao
     * @Date: 20:48 2017/5/11
     * @Param: [searchKey, orderColumn, orderType, page, pageSize, type]
     * @return: java.lang.Object
     */
    List<StoreOrderListDTO> getStoreOrderList(String searchKey,String orderColumn,String orderType,Integer page,Integer pageSize,String type);

    /**
     * @Description: 获取订单详情
     * @Author: pangweichao
     * @Date: 21:54 2017/5/11
     * @Param: [orderId]
     * @return: java.lang.Object
     */
    Order getOrderDetail(Integer orderId);

    /**
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiOrderCreateDTO> getUnpayOrders(Integer page, Integer pageSize);
}
