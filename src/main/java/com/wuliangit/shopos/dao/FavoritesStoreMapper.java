package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.FavoritesStore;

public interface FavoritesStoreMapper {
    int deleteByPrimaryKey(Integer favoritesStoreId);

    int insert(FavoritesStore record);

    int insertSelective(FavoritesStore record);

    FavoritesStore selectByPrimaryKey(Integer favoritesStoreId);

    int updateByPrimaryKeySelective(FavoritesStore record);

    int updateByPrimaryKey(FavoritesStore record);
}