package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;

public interface StoreMapper extends BaseMapper<Store, Integer> {
    /**
     * 通过用户名获取店铺简要信息
     * @param memberId
     * @return
     */
    StoreMin getStoreMin(Integer memberId);
}