package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiCollectStoreDTO;
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
}