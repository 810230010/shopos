package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.EvaluateStore;

public interface EvaluateStoreMapper {
    int deleteByPrimaryKey(Integer sevalId);

    int insert(EvaluateStore record);

    int insertSelective(EvaluateStore record);

    EvaluateStore selectByPrimaryKey(Integer sevalId);

    int updateByPrimaryKeySelective(EvaluateStore record);

    int updateByPrimaryKey(EvaluateStore record);
}