package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.api.ApiCollectStoreDTO;
import com.wuliangit.shopos.entity.FavoritesStore;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface FavoritesStoreMapper extends BaseMapper<FavoritesStore, Integer> {


    /**
     * 用户收藏店铺列表
     * @param memberId
     * @return
     */
    ArrayList<ApiCollectStoreDTO> getCollectGoodsList(Integer memberId);

    /**
     * 删除收藏店铺
     * @param storeId
     * @param memberId
     * @return
     */
    int deleteCollectGoods(@Param("storeId") Integer storeId, @Param("memberId")Integer memberId);


    /**
     * 通过用户id和店铺id获取用户收藏的店铺
     * @param memberId
     * @param storeId
     * @return
     */
    FavoritesStore getFavoritesStoreByUserIdAndStoreId(@Param("memberId")Integer memberId, @Param("storeId")Integer storeId);

    /**
     * 获取店铺收藏数量
     * @param storeId
     * @return
     */
    int getStoreCollectCount(Integer storeId);
}