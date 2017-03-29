package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.CollectGoodsDTO;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/29.
 */
public interface CollectService {

    /**
     * 用户收藏商品列表
     * @return
     */
    ArrayList<CollectGoodsDTO> getCollectGoodsList();

    /**
     * 用户收藏商品
     * @param goodsId
     * @return
     */
    int addCollectGoods(Integer goodsId);

    /**
     * 删除收藏商品
     * @param goodsId
     * @return
     */
    int deleteCollectGoods(Integer goodsId);
}
