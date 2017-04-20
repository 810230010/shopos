package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.model.StoreMin;

/**
 * Created by nilme on 2017/3/27.
 */
public interface StoreService {


    /**
     * 创建新店铺申请
     * @param storeJoinin
     * @return
     */
    int createStoreJoinin(StoreJoinin storeJoinin);

    /**
     * 通过用户名获取店铺简要信息
     * @param memberId
     * @return
     */
    StoreMin getStoreMin(Integer memberId);
}
