package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.StoreGoodsClass;

public interface StoreGoodsClassMapper {
    int deleteByPrimaryKey(Integer storeGoodsClassId);

    int insert(StoreGoodsClass record);

    int insertSelective(StoreGoodsClass record);

    StoreGoodsClass selectByPrimaryKey(Integer storeGoodsClassId);

    int updateByPrimaryKeySelective(StoreGoodsClass record);

    int updateByPrimaryKey(StoreGoodsClass record);
}