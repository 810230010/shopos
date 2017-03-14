package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.FavoritesGoods;

public interface FavoritesGoodsMapper {
    int deleteByPrimaryKey(Integer favoritesGoodId);

    int insert(FavoritesGoods record);

    int insertSelective(FavoritesGoods record);

    FavoritesGoods selectByPrimaryKey(Integer favoritesGoodId);

    int updateByPrimaryKeySelective(FavoritesGoods record);

    int updateByPrimaryKey(FavoritesGoods record);
}