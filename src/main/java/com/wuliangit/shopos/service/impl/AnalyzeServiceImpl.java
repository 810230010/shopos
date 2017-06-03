package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.AnalyzeMapper;
import com.wuliangit.shopos.dto.AdminAnalyze;
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
          analyze.put("todayIncome", "￥" + analyzeMapper.getTodayIncome(storeId));
          analyze.put("todayVisitors", 200);
          analyze.put("todayOrders", analyzeMapper.getTodayOrders(storeId));
          analyze.put("todayComments", analyzeMapper.getTodayComments(storeId));
          analyze.put("todayFinished", analyzeMapper.getDealFinishedOrders(storeId));
          analyze.put("unSured", analyzeMapper.getUnsuredOrders(storeId));
          analyze.put("waitToPay", analyzeMapper.getWatiToPayOrders(storeId));
          analyze.put("waitToSend", analyzeMapper.getWaitToSendGoods(storeId));
          analyze.put("withdrawApply", analyzeMapper.getWithdrawGoodsNum(storeId));
        return analyze;
    }

    @Override
    public AdminAnalyze adminAnalyzeAllStore() {
        AdminAnalyze analysis = new AdminAnalyze();
        analysis.put("todayIncome", analyzeMapper.adminGetAllStoreIncome());
        analysis.put("todayOrders", analyzeMapper.adminGetAllStoreTodayOrders());
        analysis.put("todayComments", analyzeMapper.adminGetTodayComments());
        analysis.put("allGoodsCount", analyzeMapper.adminGetAllStoreGoodsCount());
        analysis.put("todayNewVipNo", analyzeMapper.adminGetTodayNewVipNo());
        analysis.put("yesterdayNewVipNo", analyzeMapper.adminGetYesterdayNewVipNo());
        analysis.put("thisMonthNewVipNo", analyzeMapper.adminGetThisMonthNewAddVip());
        analysis.put("allVipNo", analyzeMapper.adminGetAllVipCount());
        analysis.put("unsuredCount", analyzeMapper.adminGetAllStoreUnsuredOrdersCount());
        analysis.put("waitToPayCount", analyzeMapper.adminGetWatiToPayOrdersCount());
        analysis.put("waitToSendCount", analyzeMapper.adminGetWaitToSendGoodsCount());
        analysis.put("finishedCount", analyzeMapper.adminGetFinishedDealCount());
        analysis.put("withdrawGoodsCount", analyzeMapper.adminGetWithdrawGoodsApplyCount());
        analysis.put("withdrawMoneyCount", analyzeMapper.adminGetWithdrawMoneyApplyCount());
        return analysis;
    }
}
