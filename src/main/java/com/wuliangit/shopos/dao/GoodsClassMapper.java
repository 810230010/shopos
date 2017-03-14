package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.GoodsClass;

public interface GoodsClassMapper {
    int deleteByPrimaryKey(Integer gcId);

    int insert(GoodsClass record);

    int insertSelective(GoodsClass record);

    GoodsClass selectByPrimaryKey(Integer gcId);

    int updateByPrimaryKeySelective(GoodsClass record);

    int updateByPrimaryKey(GoodsClass record);
}