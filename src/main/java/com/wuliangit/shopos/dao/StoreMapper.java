package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreWithBLOBs;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeId);

    int insert(StoreWithBLOBs record);

    int insertSelective(StoreWithBLOBs record);

    StoreWithBLOBs selectByPrimaryKey(Integer storeId);

    int updateByPrimaryKeySelective(StoreWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StoreWithBLOBs record);

    int updateByPrimaryKey(Store record);
}