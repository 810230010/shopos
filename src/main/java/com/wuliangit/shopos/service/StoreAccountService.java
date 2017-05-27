package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.StoreAccountLog;
import com.wuliangit.shopos.entity.StoreCash;

import java.util.List;

/**
 * Created by nilme on 2017/5/27.
 */
public interface StoreAccountService {

    /**
     *店铺资金流水记录
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<StoreAccountLog> getAccountHistoryList(Integer page, Integer pageSize, String orderColumn, String orderType);

    /**
     * 提现记录
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<StoreCash> getCashHistoryList(Integer page, Integer pageSize, String orderColumn, String orderType);
}
