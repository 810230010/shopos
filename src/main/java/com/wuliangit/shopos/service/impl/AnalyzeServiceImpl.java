package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.AnalyzeMapper;
import com.wuliangit.shopos.dto.StoreAnalyzeSimpl;
import com.wuliangit.shopos.service.AnalyzeService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nilme on 2017/6/1.
 */

@Service
public class AnalyzeServiceImpl implements AnalyzeService {
     @Autowired
     private AnalyzeMapper analyzeMapper;

    @Override
    public StoreAnalyzeSimpl getStoreAnalysis(Integer storeId) {
        StoreAnalyzeSimpl analyze = new StoreAnalyzeSimpl();
        //今日收入
        Map<String, Double> todayIncome = new HashMap<String, Double>();
        todayIncome.put("今日收入", analyzeMapper.getTodayIncome(storeId));

        //今日订单总数
        Map<String, Integer> todayOrders = new HashMap<String, Integer>();
        todayOrders.put("今日订单数", analyzeMapper.getTodayOrders(storeId));

        //今日评论数
        Map<String, Integer> todayComments = new HashMap<String, Integer>();
        todayComments.put("今日评论数", analyzeMapper.getTodayComments(storeId));

        //今日访问量
        Map<String, Integer> todayVisitors = new HashMap<String, Integer>();

        //未确认订单
        Map<String, Integer> unsuredOrders = new HashMap<String, Integer>();
        unsuredOrders.put("未确认订单", analyzeMapper.getUnsuredOrders(storeId));

        //待支付订单
        Map<String, Integer> waitTOPayOrders = new HashMap<String, Integer>();
        waitTOPayOrders.put("待支付订单", analyzeMapper.getWatiToPayOrders(storeId));

        //待发货订单
        Map<String, Integer> waitToSendOrders = new HashMap<String, Integer>();
        waitToSendOrders.put("待发货", analyzeMapper.getWaitToSendGoods(storeId));

        //已成交
        Map<String, Integer> alreadyPayedOrders = new HashMap<String, Integer>();
        alreadyPayedOrders.put("已成交", analyzeMapper.getDealFinishedOrders(storeId));

        //退货申请
        Map<String, Integer> withdrawGoodsApplyNum = new HashMap<String, Integer>();
        withdrawGoodsApplyNum.put("退货申请", analyzeMapper.getWithdrawGoodsNum(storeId));

        analyze.setTodayIncome(todayIncome);
        analyze.setTodayOrders(todayOrders);
        analyze.setTodayComments(todayComments);
        analyze.setAlreadyPayedOrders(alreadyPayedOrders);
        analyze.setUnsuredOrders(unsuredOrders);
        analyze.setWaitTOPayOrders(waitTOPayOrders);
        analyze.setWaitToSendOrders(waitToSendOrders);
        analyze.setWithdrawGoodsApplyNum(withdrawGoodsApplyNum);
        return analyze;
    }
}
