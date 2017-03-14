package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.GoodsColor;

public interface GoodsColorMapper {
    int deleteByPrimaryKey(Integer goodsColorId);

    int insert(GoodsColor record);

    int insertSelective(GoodsColor record);

    GoodsColor selectByPrimaryKey(Integer goodsColorId);

    int updateByPrimaryKeySelective(GoodsColor record);

    int updateByPrimaryKey(GoodsColor record);
}