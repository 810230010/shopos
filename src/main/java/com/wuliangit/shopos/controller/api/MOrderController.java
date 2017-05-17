package com.wuliangit.shopos.controller.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.dto.ApiOrderDTO;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.OrderGoodsInfo;
import com.wuliangit.shopos.service.OrderService;
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
            carriageAmount = carriageAmount.add(order.getCarriage());
            goodsAmount = goodsAmount.add(order.getGoodsAmount());
            orderAmount = orderAmount.add(order.getOrderAmount());
            if (flag == 0) {
                carriageInfo += order.getCarriage().toString();
                flag = 1;
            } else {
                carriageInfo += "+" + order.getCarriage().toString();
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
     * 获取未付款订单
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/unpay")
    public Object getUnpayOrders(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        RestResult result = new RestResult();
        List<ApiOrderDTO> orders = orderService.getUnpayOrders(page,pageSize);
        result.add("orders",orders);
        return result;
    }




}
