package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.FavoritesGoodsMapper;
import com.wuliangit.shopos.dao.FavoritesStoreMapper;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.dto.ApiCollectGoodsDTO;
import com.wuliangit.shopos.dto.ApiCollectStoreDTO;
import com.wuliangit.shopos.entity.*;
import com.wuliangit.shopos.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nilme on 2017/3/29.
 */

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private FavoritesGoodsMapper favoritesGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private FavoritesStoreMapper favoritesStoreMapper;
    @Autowired
    private StoreMapper storeMapper;



    @Override
    public ArrayList<ApiCollectGoodsDTO> getCollectGoodsList(Integer page, Integer pageSize) {
        Member user = WebUtil.getCurrentMember();
        PageHelper.startPage(page,pageSize);
        ArrayList<ApiCollectGoodsDTO> collectGoods = favoritesGoodsMapper.getCollectGoodsList(user.getMemberId());
        return collectGoods;
    }

    @Override
    public int addCollectGoods(Integer goodsId) {
        Member user = WebUtil.getCurrentMember();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        FavoritesGoods favoritesGoods = new FavoritesGoods();
        favoritesGoods.setFavTime(new Date());
        favoritesGoods.setGoodsId(goods.getGoodsId());
        favoritesGoods.setGoodsName(goods.getName());
        favoritesGoods.setLogPrice(goods.getPrice());
        favoritesGoods.setMemberId(user.getMemberId());
        favoritesGoods.setMemberName(user.getNikename());
        return favoritesGoodsMapper.insertSelective(favoritesGoods);
    }

    @Override
    public int deleteCollectGoods(Integer goodsId) {
        Member user = WebUtil.getCurrentMember();
        return favoritesGoodsMapper.deleteCollectGoods(goodsId,user.getMemberId());
    }

    @Override
    public ArrayList<ApiCollectStoreDTO> getCollectStireList(Integer page, Integer pageSize) {
        Member user = WebUtil.getCurrentMember();
        PageHelper.startPage(page,pageSize);
        ArrayList<ApiCollectStoreDTO> collectStores = favoritesStoreMapper.getCollectGoodsList(user.getMemberId());
        return collectStores;
    }

    @Override
    public int addCollectStore(Integer storeId) {
        Member user = WebUtil.getCurrentMember();
        Store store = storeMapper.selectByPrimaryKey(storeId);
        FavoritesStore favoritesStore = new FavoritesStore();
        favoritesStore.setMemberName(user.getNikename());
        favoritesStore.setMemberId(user.getMemberId());
        favoritesStore.setLogMsg("app collect");
        favoritesStore.setFavTime(new Date());
        favoritesStore.setStoreName(store.getName());
        favoritesStore.setStoreId(store.getStoreId());
        return favoritesStoreMapper.insertSelective(favoritesStore);
    }

    @Override
    public int deleteCollectStore(Integer storeId) {
        Member user = WebUtil.getCurrentMember();
        return favoritesStoreMapper.deleteCollectGoods(storeId,user.getMemberId());
    }
}
