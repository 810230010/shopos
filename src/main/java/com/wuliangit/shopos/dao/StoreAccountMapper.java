package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.StoreAccount;

public interface StoreAccountMapper extends BaseMapper<StoreAccount, Integer> {

    /**
     * 通过店铺id获取店铺账户
     * @param storeId
     * @return
     */
    StoreAccount getByStoreId(Integer storeId);
}