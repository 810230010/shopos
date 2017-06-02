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
          analyze.put("今日收入", analyzeMapper.getTodayIncome(storeId));
          analyze.put("今日访问量", 200);
          analyze.put("今日订单", analyzeMapper.getTodayOrders(storeId));
          analyze.put("今日评论数", analyzeMapper.getTodayComments(storeId));
          analyze.put("交易成功", analyzeMapper.getDealFinishedOrders(storeId));
          analyze.put("未确认", analyzeMapper.getUnsuredOrders(storeId));
          analyze.put("待付款", analyzeMapper.getWatiToPayOrders(storeId));
          analyze.put("待发货", analyzeMapper.getWaitToSendGoods(storeId));
          analyze.put("退货申请", analyzeMapper.getWithdrawGoodsNum(storeId));
        return analyze;
    }
}
