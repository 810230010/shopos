package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiCollectGoodsDTO;
import com.wuliangit.shopos.dto.ApiCollectStoreDTO;
import com.wuliangit.shopos.exception.OptionException;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/29.
 */
public interface CollectService {

    /**
     * 用户收藏商品列表
     * @return
     * @param page
     * @param pageSize
     */
    ArrayList<ApiCollectGoodsDTO> getCollectGoodsList(Integer page, Integer pageSize);

    /**
     * 用户收藏商品
     * @param goodsId
     * @return
     */
    int addCollectGoods(Integer goodsId) throws Exception;

    /**
     * 删除收藏商品
     * @param goodsId
     * @return
     */
    int deleteCollectGoods(Integer goodsId);

    /**
     * 用户收藏店铺列表
     * @param page
     * @param pageSize
     * @return
     */
    ArrayList<ApiCollectStoreDTO> getCollectStireList(Integer page, Integer pageSize);

    /**
     * 用户收藏店铺
     * @param storeId
     * @return
     */
    int addCollectStore(Integer storeId) throws Exception;

    /**
     * 删除收藏店铺
     * @param storeId
     * @return
     */
    int deleteCollectStore(Integer storeId);

    /**
     * 是否收藏商品
     * @param goodsId
     * @return
     */
    boolean isCollectGoods(Integer goodsId);

    /**
     * 是否收藏商品
     * @param storeId
     * @return
     */
    boolean isCollectStore(Integer storeId);
}
