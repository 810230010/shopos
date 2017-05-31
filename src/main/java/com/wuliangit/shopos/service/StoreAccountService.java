package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.entity.StoreAccountLog;
import com.wuliangit.shopos.entity.StoreCash;
import com.wuliangit.shopos.exception.OptionException;

import java.math.BigDecimal;
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

    /**
     * 获取店铺账户信息
     * @return
     */
    StoreAccount getStoreAccount();

    /**
     * 创建店铺账户
     * @param storeId
     */
    int createStoreAccount(Integer storeId);

    /**
     * 店铺提现
     * @param amount
     * @return
     */
    int storeDoCash(BigDecimal amount) throws OptionException;

    /**
     * 设置店铺提现支付宝账户
     * @param alipayAccount
     * @return
     */
    int settingStoreAlipay(String alipayAccount);
}
