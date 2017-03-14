package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.StoreJoinin;

public interface StoreJoininMapper {
    int deleteByPrimaryKey(Integer memberId);

    int insert(StoreJoinin record);

    int insertSelective(StoreJoinin record);

    StoreJoinin selectByPrimaryKey(Integer memberId);

    int updateByPrimaryKeySelective(StoreJoinin record);

    int updateByPrimaryKey(StoreJoinin record);
}