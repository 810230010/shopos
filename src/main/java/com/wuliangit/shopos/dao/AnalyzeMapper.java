package com.wuliangit.shopos.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 统计相关
 * Created by nilme on 2017/6/1.
 */
public interface AnalyzeMapper {
    /**
     * 得到店铺今日总收入
     * @return
     */
    double getTodayIncome(@Param("storeId") Integer storeId);

    /**
     * 得到店铺今日订单数
     * @return
     */
    Integer getTodayOrders(@Param("storeId")Integer storeId);

    /**
     * 得到店铺今日商品评论总数
     * @return
     */
    Integer getTodayComments(@Param("storeId")Integer storeId);

    /**
     * 商铺未确认订单数
     * @param storeId
     * @return
     */
    Integer getUnsuredOrders(@Param("storeId")Integer storeId);

    /**
     * 待支付订单数
     * @param storeId
     * @return
     */
    Integer getWatiToPayOrders(@Param("storeId")Integer storeId);

    /**
     * 待发货订单数
     * @param storeId
     * @return
     */
    Integer getWaitToSendGoods(@Param("storeId")Integer storeId);

    /**
     * 店铺交易成功订单数
     * @param storeId
     * @return
     */
    Integer getDealFinishedOrders(@Param("storeId")Integer storeId);

    /**
     * 店铺申请退货数
     * @param storeId
     * @return
     */
    Integer getWithdrawGoodsNum(@Param("storeId")Integer storeId);
}
