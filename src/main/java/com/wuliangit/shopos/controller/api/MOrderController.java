package com.wuliangit.shopos.controller.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.dto.ApiOrderDTO;
import com.wuliangit.shopos.dto.ApiRefundDTO;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.entity.Refund;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.OrderGoodsInfo;
import com.wuliangit.shopos.service.OrderService;
import com.wuliangit.shopos.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单相关
 * Created by nilme on 2017/5/3.
 */

@RestController
@RequestMapping(value = "/api/v1/order")
public class MOrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private RefundService refundService;

    /**
     * 创建订单
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Object createOrder(@RequestParam(required = true) String orderGoodsInfoList,
                              @RequestParam(required = true) Integer addressId,
                              @RequestParam(required = true) String orderFrom,
                              @RequestParam(required = true) String orderMessage) throws OrderException {
        RestResult result = new RestResult();

        Gson gson = new Gson();
        List<OrderGoodsInfo> orderGoodsInfoListObj = gson.fromJson(orderGoodsInfoList, new TypeToken<List<OrderGoodsInfo>>() {
        }.getType());

        List<Order> orders = orderService.ApiCreateOrder(orderGoodsInfoListObj, addressId, orderFrom, orderMessage);

        List<Integer> orderIds = new ArrayList<>();

        //设置订单价格
        //商品总价
        BigDecimal goodsAmount = new BigDecimal("0");
        BigDecimal orderAmount = new BigDecimal("0");
        //邮费总价
        BigDecimal carriageAmount = new BigDecimal("0");
        String carriageInfo = "";

        int flag = 0;
        for (Order order : orders) {
            carriageAmount = carriageAmount.add(order.getCarriageAmount());
            goodsAmount = goodsAmount.add(order.getGoodsAmount());
            orderAmount = orderAmount.add(order.getOrderAmount());
            if (flag == 0) {
                carriageInfo += order.getCarriageAmount().toString();
                flag = 1;
            } else {
                carriageInfo += "+" + order.getCarriageAmount().toString();
            }
            orderIds.add(order.getOrderId());
        }

        result.add("goodsAmount", goodsAmount);
        result.add("carriageAmount", carriageAmount);
        result.add("orderAmount", orderAmount);
        result.add("carriageInfo", carriageInfo);
        result.add("orderIds", orderIds);
        return result;
    }

    /**
     * 待付款订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/unpay")
    public Object getUnpayOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        List<ApiOrderDTO> orders = orderService.apiGetUnpayOrders(page, pageSize);
        result.add("orders", orders);
        return result;
    }

    /**
     * 待发货订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/payed")
    public Object getPayedOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        List<ApiOrderDTO> orders = orderService.apiGetPayedOrders(page, pageSize);
        result.add("orders", orders);
        return result;
    }

    /**
     * 待收货订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/delived")
    public Object getDelivedOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        List<ApiOrderDTO> orders = orderService.apiGetDelivedOrders(page, pageSize);
        result.add("orders", orders);
        return result;
    }

    /**
     * 待评价订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/unEvaluate")
    public Object getReceivedOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        List<ApiOrderDTO> orders = orderService.apiGetUnEvaluateOrders(page, pageSize);
        result.add("orders", orders);
        return result;
    }


    /**
     * 退款退货订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/refundList")
    public Object getRefundOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        List<ApiRefundDTO> refunds = refundService.apiGetRefundOrders(page, pageSize);
        result.add("refunds", refunds);
        return result;
    }

    /**
     * 所有订单
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/all")
    public Object getAllOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        List<ApiOrderDTO> orders = orderService.apiGetAllOrders(page, pageSize);
        result.add("orders", orders);
        return result;
    }

    /**
     * 确认收货
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/receive")
    public Object receive(Integer orderId) {
        RestResult result = new RestResult();
        int res = orderService.receive(orderId);
        return result;
    }


    /**
     * 申请退货
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/refund")
    public Object refund(Integer orderId, Integer goodsId,String refundType, String goodsState, String buyerMessage) throws Exception {
        RestResult result = new RestResult();
        int res = orderService.refund(orderId, goodsId, refundType, goodsState, buyerMessage);
        return result;
    }

    /**
     * 买家退货填写物流信息
     * @return
     */
    @RequestMapping("/refund/delive")
    public Object refundDelive(Integer refundId, String expressName, String expressNo) throws Exception {
        RestResult result = new RestResult();
        int res = orderService.refundDelive(refundId, expressName, expressNo);
        return result;
    }

}
