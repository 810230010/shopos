package com.wuliangit.shopos.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nilme on 2017/6/1.
 */
public class StoreAnalyzeSimpl {
    //今日收入
     private Map<String, Double> todayIncome;
     //今日订单总数
     private Map<String, Integer> todayOrders;
     //今日评论数
     private Map<String, Integer> todayComments;
     //今日访问量
     private Map<String, Integer> todayVisitors;
     //未确认订单
     private Map<String, Integer> unsuredOrders;
     //待支付订单
     private Map<String, Integer> waitTOPayOrders;
    //待发货订单
     private Map<String, Integer> waitToSendOrders;
    //已成交
    private Map<String, Integer> alreadyPayedOrders;
    //退货申请
    private Map<String, Integer> withdrawGoodsApplyNum;

    public Map<String, Double> getTodayIncome() {
        return todayIncome;
    }

    public void setTodayIncome(Map<String, Double> todayIncome) {
        this.todayIncome = todayIncome;
    }

    public Map<String, Integer> getTodayOrders() {
        return todayOrders;
    }

    public void setTodayOrders(Map<String, Integer> todayOrders) {
        this.todayOrders = todayOrders;
    }

    public Map<String, Integer> getTodayComments() {
        return todayComments;
    }

    public void setTodayComments(Map<String, Integer> todayComments) {
        this.todayComments = todayComments;
    }

    public Map<String, Integer> getTodayVisitors() {
        return todayVisitors;
    }

    public void setTodayVisitors(Map<String, Integer> todayVisitors) {
        this.todayVisitors = todayVisitors;
    }

    public Map<String, Integer> getUnsuredOrders() {
        return unsuredOrders;
    }

    public void setUnsuredOrders(Map<String, Integer> unsuredOrders) {
        this.unsuredOrders = unsuredOrders;
    }

    public Map<String, Integer> getWaitTOPayOrders() {
        return waitTOPayOrders;
    }

    public void setWaitTOPayOrders(Map<String, Integer> waitTOPayOrders) {
        this.waitTOPayOrders = waitTOPayOrders;
    }

    public Map<String, Integer> getWaitToSendOrders() {
        return waitToSendOrders;
    }

    public void setWaitToSendOrders(Map<String, Integer> waitToSendOrders) {
        this.waitToSendOrders = waitToSendOrders;
    }

    public Map<String, Integer> getAlreadyPayedOrders() {
        return alreadyPayedOrders;
    }

    public void setAlreadyPayedOrders(Map<String, Integer> alreadyPayedOrders) {
        this.alreadyPayedOrders = alreadyPayedOrders;
    }

    public Map<String, Integer> getWithdrawGoodsApplyNum() {
        return withdrawGoodsApplyNum;
    }

    public void setWithdrawGoodsApplyNum(Map<String, Integer> withdrawGoodsApplyNum) {
        this.withdrawGoodsApplyNum = withdrawGoodsApplyNum;
    }
}