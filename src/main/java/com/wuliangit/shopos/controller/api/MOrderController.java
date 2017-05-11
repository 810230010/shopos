package com.wuliangit.shopos.controller.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public Object createOrder(ApiOrderCreateDTO orderInfo) throws OrderException {
        RestResult result = new RestResult();
        List<Order> orders = orderService.ApiCreateOrder(orderInfo);

        List<Integer> orderIds = new ArrayList<>();

        //设置订单价格
        //商品总价
        BigDecimal goodsAmount = new BigDecimal(0);
        //邮费总价
        BigDecimal carriage = new BigDecimal(0);
        String carriageInfo = "";

        int flag = 0;
        for (Order order : orders) {
            carriage.add(order.getCarriage());
            goodsAmount.add(order.getGoodsAmount());
            if (flag == 0 ){
                carriageInfo += order.getCarriage().toString();
                flag= 1;
            }else{
                carriageInfo += "+"+order.getCarriage().toString();
            }
            orderIds.add(order.getOrderId());
        }

        result.add("goodsAmount",goodsAmount);
        result.add("carriageAmount",carriage);
        result.add("orderAmount",goodsAmount.add(carriage));
        result.add("carriageInfo",carriageInfo);
        result.add("orderIds",orderIds);

        return result;
    }


}
