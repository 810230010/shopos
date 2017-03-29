package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.StoreJoinin;

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
}
