package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
import com.wuliangit.shopos.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @Description: 商铺获取订单列表数据
     * @Author: pangweichao
     * @Date: 20:48 2017/5/11
     * @Param: [searchKey, orderColumn, orderType, type]
     * @return: java.lang.Object
     */
    List<StoreOrderListDTO> getStoreOrderList(@Param("searchKey") String searchKey,@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("type") String type);

}