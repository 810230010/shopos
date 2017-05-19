package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiOrderGoodsDTO;
import com.wuliangit.shopos.dto.OrderDetailGoodsListDTO;
import com.wuliangit.shopos.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsMapper extends BaseMapper<OrderGoods, Integer> {


    /**
     * 通过订单id获取订单商品信息
     * @param orderId
     * @return
     */
    List<ApiOrderGoodsDTO> getByOrderId(Integer orderId);

    /**
     * 订单详情获取订单商品信息
     * @param orderId
     * @return
     */
    List<OrderDetailGoodsListDTO> getOrderDetailGoods(Integer orderId);
}