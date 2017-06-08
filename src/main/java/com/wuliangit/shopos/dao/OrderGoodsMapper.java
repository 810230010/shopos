package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiOrderGoodsDTO;
import com.wuliangit.shopos.dto.OrderDetailGoodsListDTO;
import com.wuliangit.shopos.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper extends BaseMapper<OrderGoods, Integer> {


    /**
     * 通过订单id获取订单商品信息
     * @param orderId
     * @return
     */
    List<ApiOrderGoodsDTO> apiGetByOrderId(Integer orderId);

    /**
     * 通过订单id获取订单商品信息
     * @param orderId
     * @return
     */
    List<OrderGoods> getByOrderId(Integer orderId);


    /**
     * 通过商品id和订单id获取订单商品
     * @param orderId
     * @param goodsId
     * @return
     */
    OrderGoods getByOrderIdAndGoodsId(@Param("orderId") Integer orderId, @Param("goodsId")Integer goodsId);

    /**
     * 获取商品有效订单数量
     * @param goodsId
     * @return
     */
    int getGoodsOrderCount(Integer goodsId);
}