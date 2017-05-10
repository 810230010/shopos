package com.wuliangit.shopos.service;

import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;

import java.util.List;

/**
 * Created by nilme on 2017/5/5.
 */
public interface OrderService {


    /**
     * 创建订单
     * @param orderInfo
     * @return
     */
    List<Order> ApiCreateOrder(ApiOrderCreateDTO orderInfo) throws OrderException;

}
