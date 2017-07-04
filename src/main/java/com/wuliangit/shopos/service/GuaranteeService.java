package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.GuaranteeOrder;

/**
 * Created by Administrator on 2017/7/4.
 */
public interface GuaranteeService {
     /**
      * 新增支付保证金订单
      * @return
      */
     int insertGuaranteeOrder(GuaranteeOrder order);

     /**
      * orderId得到保证金订单
      * @param orderId
      * @return
      */
     GuaranteeOrder getGuaranteeOrderByOrderID(Integer orderId);

     /**
      *
      * @return
      */
     GuaranteeOrder getGuaranteeOrderByOutTradeNo(String outTradeNo);

     /**
      * 更改保证金订单状态
      * @param order
      * @return
      */
     int updateGuaranteeOrder(GuaranteeOrder order);
}
