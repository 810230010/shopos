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
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        PageHelper.startPage(page, pageSize);
        ArrayList<ApiCollectGoodsDTO> collectGoods = favoritesGoodsMapper.getCollectGoodsList(user.getMemberId());
        return collectGoods;
    }

    @Override
    public int addCollectGoods(Integer goodsId) throws Exception {
        Member member = WebUtil.getCurrentMember();

        FavoritesGoods oldFavoritesGoods = favoritesGoodsMapper.getFavoritesGoodsByUserIdAndGoodsId(member.getMemberId(), goodsId);

        if (oldFavoritesGoods != null) {
            throw new OptionException("重复收藏");
        }

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);

        if (goods == null) {
            throw new OptionException("商品不存在");
        }

        FavoritesGoods favoritesGoods = new FavoritesGoods();
        favoritesGoods.setFavTime(new Date());
        favoritesGoods.setGoodsId(goods.getGoodsId());
        favoritesGoods.setGoodsName(goods.getName());
        favoritesGoods.setLogPrice(goods.getPrice());
        favoritesGoods.setMemberId(member.getMemberId());
        favoritesGoods.setMemberName(member.getNikename());
        return favoritesGoodsMapper.insertSelective(favoritesGoods);
    }

    @Override
    public int deleteCollectGoods(Integer goodsId) {
        Member user = WebUtil.getCurrentMember();
        return favoritesGoodsMapper.deleteCollectGoods(goodsId, user.getMemberId());
    }

    @Override
    public ArrayList<ApiCollectStoreDTO> getCollectStireList(Integer page, Integer pageSize) {
        Member user = WebUtil.getCurrentMember();
        PageHelper.startPage(page, pageSize);
        ArrayList<ApiCollectStoreDTO> collectStores = favoritesStoreMapper.getCollectGoodsList(user.getMemberId());
        return collectStores;
    }

    @Override
    public int addCollectStore(Integer storeId) throws Exception {
        Member member = WebUtil.getCurrentMember();
        FavoritesStore oldFavoritesStore = favoritesStoreMapper.getFavoritesStoreByUserIdAndStoreId(member.getMemberId(), storeId);

        if (oldFavoritesStore != null) {
            throw new OptionException("重复收藏");
        }

        Store store = storeMapper.selectByPrimaryKey(storeId);

        if (store == null) {
            throw new OptionException("店铺不存在");
        }

        FavoritesStore favoritesStore = new FavoritesStore();
        favoritesStore.setMemberName(member.getNikename());
        favoritesStore.setMemberId(member.getMemberId());
        favoritesStore.setLogMsg("app collect");
        favoritesStore.setFavTime(new Date());
        favoritesStore.setStoreName(store.getName());
        favoritesStore.setStoreId(store.getStoreId());
        return favoritesStoreMapper.insertSelective(favoritesStore);
    }

    @Override
    public int deleteCollectStore(Integer storeId) {
        Member member = WebUtil.getCurrentMember();
        return favoritesStoreMapper.deleteCollectGoods(storeId, member.getMemberId());
    }

    @Override
    public boolean isCollectGoods(Integer goodsId) {
        Member member = WebUtil.getCurrentMember();
        FavoritesGoods favoritesGoods = favoritesGoodsMapper.getFavoritesGoodsByUserIdAndGoodsId(member.getMemberId(), goodsId);
        if (favoritesGoods != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCollectStore(Integer storeId) {
        Member member = WebUtil.getCurrentMember();
        FavoritesStore favoritesStore = favoritesStoreMapper.getFavoritesStoreByUserIdAndStoreId(member.getMemberId(), storeId);
        if (favoritesStore != null) {
            return true;
        }
        return false;
    }
}
