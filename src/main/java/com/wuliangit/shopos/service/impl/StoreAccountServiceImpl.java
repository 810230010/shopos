package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreAccountLogMapper;
import com.wuliangit.shopos.dao.StoreCashMapper;
import com.wuliangit.shopos.entity.StoreAccountLog;
import com.wuliangit.shopos.entity.StoreCash;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
