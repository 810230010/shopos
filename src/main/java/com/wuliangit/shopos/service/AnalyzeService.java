package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.StoreAnalyzeSimpl;

/**
 * Created by nilme on 2017/6/1.
 */
public interface AnalyzeService {
    /**
     * 得到商铺所有统计情况
     * @return
     */
     StoreAnalyzeSimpl getStoreAnalysis(Integer storeId);



}
