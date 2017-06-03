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
    Double getTodayIncome(@Param("storeId") Integer storeId);

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
    // ====================================
    //管理员

    /**
     * 得到所有店铺总收入
     * @return
     */
    Double adminGetAllStoreIncome();

    /**
     * 管理员得到所有店铺今日订单数
     * @return
     */
    Integer adminGetAllStoreTodayOrders();

    /**
     * 管理员得到所有店铺今日商品评论总数
     * @return
     */
    Integer adminGetTodayComments();

    /**
     * 今日新增会员
     * @return
     */
    Integer adminGetTodayNewVipNo();

    /**
     * 昨日新增会员
     * @return
     */
    Integer adminGetYesterdayNewVipNo();

    /**
     * 本月新增会员
     * @return
     */
    Integer adminGetThisMonthNewAddVip();

    /**
     * 得到所有会员总数
     * @return
     */
    Integer adminGetAllVipCount();
    /**
     * 所有店铺商品总数
     * @return
     */
    Integer adminGetAllStoreGoodsCount();

    /**
     * 所有店铺未确认订单总数
     * @return
     */
    Integer adminGetAllStoreUnsuredOrdersCount();

    /**
     * 所有店铺待支付订单数
     * @return
     */
    Integer adminGetWatiToPayOrdersCount();

    /**
     * 所有店铺待发货订单数
     * @return
     */
     Integer adminGetWaitToSendGoodsCount();

    /**
     * 所有店铺已成交订单
     * @return
     */
    Integer adminGetFinishedDealCount();

    /**
     * 所有店铺退货申请人数
     * @return
     */
    Integer adminGetWithdrawGoodsApplyCount();

    /**
     * 所有店铺用户退款申请人数
     * @return
     */
    Integer adminGetWithdrawMoneyApplyCount();
}
