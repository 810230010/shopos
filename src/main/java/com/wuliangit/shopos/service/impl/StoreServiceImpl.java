package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.StoreJoininMapper;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nilme on 2017/3/27.
 */

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreJoininMapper storeJoininMapper;

    @Override
    public int createStoreJoinin(StoreJoinin storeJoinin) {
        return storeJoininMapper.insertSelective(storeJoinin);
    }
}
