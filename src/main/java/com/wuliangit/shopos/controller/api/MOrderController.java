package com.wuliangit.shopos.controller.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.OrderGoodsInfo;
import com.wuliangit.shopos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单相关
 * Created by nilme on 2017/5/3.
 */

@Controller
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
    @ResponseBody
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


}
