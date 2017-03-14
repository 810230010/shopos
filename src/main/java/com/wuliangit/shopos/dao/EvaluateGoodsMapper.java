package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.EvaluateGoods;

public interface EvaluateGoodsMapper {
    int deleteByPrimaryKey(Integer gevalId);

    int insert(EvaluateGoods record);

    int insertSelective(EvaluateGoods record);

    EvaluateGoods selectByPrimaryKey(Integer gevalId);

    int updateByPrimaryKeySelective(EvaluateGoods record);

    int updateByPrimaryKey(EvaluateGoods record);
}