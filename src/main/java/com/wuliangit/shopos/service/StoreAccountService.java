package com.wuliangit.shopos.service;

import com.alipay.api.AlipayApiException;
import com.wuliangit.shopos.dto.StoreAccountListDTO;
import com.wuliangit.shopos.dto.StoreCashListDTO;
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
    int storeDoCash(BigDecimal amount) throws OptionException, AlipayApiException;

    /**
     * 设置店铺提现支付宝账户
     * @param alipayAccount
     * @return
     */
    int settingStoreAlipay(String alipayAccount);

    /**
     * @Description: 获取商家账户管理页面list数据
     * @Author: pangweichao
     * @Date: 10:15 2017/6/2
     * @Param: [page, pageSize, orderColumn, orderType, searchKey]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreAccountListDTO>
     */
    List<StoreAccountListDTO> getStoreAccountListDate(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * @Description: 获取订单佣金管理
     * @Author: pangweichao
     * @Date: 10:16 2017/6/2
     * @Param: [page, pageSize, orderColumn, orderType, searchKey]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreCashListDTO>
     */
    List<StoreCashListDTO> getCashListDate(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * API店铺支付宝提现
     * @param amount
     * @return
     */
    int apisStoreDoCash(BigDecimal amount) throws OptionException, AlipayApiException;

    /**
     * API修改提现支付宝账户
     * @param alipayAccount
     * @return
     */
    int apiSettingStoreAlipay(String alipayAccount);

    /**
     * 获取现有提现支付宝账户
     * @return
     */
    StoreAccount apiGetAlipayCashAccount() throws OptionException;
}
