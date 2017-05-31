package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreAccountLogMapper;
import com.wuliangit.shopos.dao.StoreAccountMapper;
import com.wuliangit.shopos.dao.StoreCashMapper;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.entity.StoreAccountLog;
import com.wuliangit.shopos.entity.StoreCash;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreAccountService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nilme on 2017/5/27.
 */

@Service
public class StoreAccountServiceImpl implements StoreAccountService {

    @Autowired
    private StoreAccountLogMapper storeAccountLogMapper;
    @Autowired
    private StoreCashMapper storeCashMapper;
    @Autowired
    private StoreAccountMapper storeAccountMapper;

    @Override
    public List<StoreAccountLog> getAccountHistoryList(Integer page, Integer pageSize, String orderColumn, String orderType) {
        PageHelper.startPage(page,pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreAccountLog> storeAccountLogs = storeAccountLogMapper.getAccountHistoryList(store.getStoreId(),orderColumn,orderType);
        return storeAccountLogs;
    }

    @Override
    public List<StoreCash> getCashHistoryList(Integer page, Integer pageSize, String orderColumn, String orderType) {
        PageHelper.startPage(page,pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreCash> storeCashes = storeCashMapper.getCashHistoryList(store.getStoreId(),orderColumn,orderType);
        return storeCashes;
    }

    @Override
    public StoreAccount getStoreAccount() {
        StoreMin store = WebUtil.getCurrentStore();
        return storeAccountMapper.getByStoreId(store.getStoreId());
    }

    @Override
    public int createStoreAccount(Integer storeId) {
        StoreAccount storeAccount = new StoreAccount();
        storeAccount.setStoreId(storeId);
        return storeAccountMapper.insertSelective(storeAccount);
    }

    @Override
    @Transactional
    public int storeDoCash(BigDecimal amount) throws OptionException {
        StoreMin currentStore = WebUtil.getCurrentStore();
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(currentStore.getStoreId());

        //验证是否设置支付宝提现账户
        if (StringUtils.isEmpty(storeAccount.getAlipayAccount())){
            throw new OptionException("未设置提现支付宝账户");
        }




        return 0;
    }

    @Override
    public int settingStoreAlipay(String alipayAccount) {
        StoreMin currentStore = WebUtil.getCurrentStore();
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(currentStore.getStoreId());
        storeAccount.setAlipayAccount(alipayAccount);
        return storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
    }
}
