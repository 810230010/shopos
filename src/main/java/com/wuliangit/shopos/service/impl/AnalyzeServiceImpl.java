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
}
