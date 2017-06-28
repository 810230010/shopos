package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiOrderDTO;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
import com.wuliangit.shopos.entity.Order;
import org.apache.ibatis.annotations.Param;
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
     * @Param: [searchKey, orderColumn, orderType, state]
     * @return: java.lang.Object
     */
    List<StoreOrderListDTO> getStoreOrderList(@Param("searchKey") String searchKey,
                                              @Param("orderColumn") String orderColumn,
                                              @Param("orderType") String orderType,
                                              @Param("state") String state,
                                              @Param("storeId") Integer storeId);

    /**
     * api接口获取订单
     * @param orderState  订单状态
     * @param memberId 用户id
     * @return
     */
    List<ApiOrderDTO> apiGetOrderByStateAndMemberId(@Param("orderState")String orderState,
                                                    @Param("memberId")Integer memberId);

    /**
     * api接口获取所有订单
     * @param memberId 用户id
     * @return
     */
    List<ApiOrderDTO> apiGetOrderByMemberId(Integer memberId);

    /**
     * 获取未评价接口
     * @param memberId
     * @return
     */
    List<ApiOrderDTO> apiGetUnEvaluateOrderByMemberId(Integer memberId);


    /**
     * API接口获取订单列表
     * @param state
     * @param storeId
     * @return
     */
    List<StoreOrderListDTO> apiGetStoreOrderList(@Param("state")String state, @Param("storeId")Integer storeId);

    /**
     * @Description: admin获取所有订单列表数据
     * @Author: pangweichao
     * @Date: 20:48 2017/5/11
     * @Param: [searchKey, orderColumn, orderType, page, pageSize, type]
     * @return: java.lang.Object
     */
    List<StoreOrderListDTO> getAdminOrderList(@Param("searchKey") String searchKey,
                                              @Param("orderColumn") String orderColumn,
                                              @Param("orderType") String orderType,
                                              @Param("state") String state);
}