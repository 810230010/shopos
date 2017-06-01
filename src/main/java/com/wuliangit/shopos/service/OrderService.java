package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.*;
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
     *
     * @param orderGoodsInfoList
     * @param addressId
     * @param orderFrom
     * @param orderMessage
     * @return
     * @throws OrderException
     */
    List<Order> ApiCreateOrder(List<OrderGoodsInfo> orderGoodsInfoList, Integer addressId, String orderFrom, String orderMessage) throws OrderException;

    /**
     * 通过id获取订单
     *
     * @param orderId
     * @return
     */
    Order getOrderById(Integer orderId);

    /**
     * 更新订单信息
     *
     * @param order
     * @return
     */
    int updateOrder(Order order);

    /**
     * 获取合并的订单
     *
     * @param outTradeNo
     * @return
     */
    List<Order> getOrderByOutTradeNoMerge(String outTradeNo);

    /**
     * 获取当个订单
     *
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
    List<StoreOrderListDTO> getStoreOrderList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, String state);

    /**
     * @Description: 获取订单详情
     * @Author: pangweichao
     * @Date: 21:54 2017/5/11
     * @Param: [orderId]
     * @return: java.lang.Object
     */
    Order getOrderDetail(Integer orderId);

    /**
     * 获取未付款订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiOrderDTO> apiGetUnpayOrders(Integer page, Integer pageSize);


    /**
     * 待发货订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiOrderDTO> apiGetPayedOrders(Integer page, Integer pageSize);

    /**
     * 待收货订单
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiOrderDTO> apiGetDelivedOrders(Integer page, Integer pageSize);

    /**
     * 待评价订单
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiOrderDTO> apiGetUnEvaluateOrders(Integer page, Integer pageSize);

    /**
     * 所有订单
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiOrderDTO> apiGetAllOrders(Integer page, Integer pageSize);

    /**
     * 订单详情获取订单商品信息
     * @param orderId
     * @return
     */
    List<ApiOrderGoodsDTO> getOrderDetailGoods(Integer orderId);

    /**
     * 添加发货信息
     * @param expressId
     * @param expressNo
     * @param orderId
     * @return
     */
    int addExpressInfo(Integer expressId, String expressNo, Integer orderId);

    /**
     * 确认收货
     * @param orderId
     * @return
     */
    int receive(Integer orderId);

    /**
     * 申请退货
     * @param orderId
     * @param goodsId
     * @param refundType
     * @param goodsState
     * @param buyerMessage
     * @param picsInfo    */
    int refund(Integer orderId, Integer goodsId, String refundType, String goodsState, String buyerMessage, String picsInfo) throws Exception;

    /**
     * 买家退货填写物流信息
     * @param refundId
     * @param expressName
     * @param expressNo
     * @param expressCode
     * @return
     */
    int refundDelive(Integer refundId, String expressName, String expressNo, String expressCode);

    /**
     * 取消未支付订单（已发货）
     * @param orderId
     * @return
     */
    int cancelUnpay(Integer orderId) throws Exception;

    /**
     * 取消已支付订单（未发货）
     * @param orderId
     * @return
     */
    int cancelPayed(Integer orderId) throws Exception;

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int apiDelete(Integer orderId) throws Exception;
}
