package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.core.util.WebUtil;
import com.wuliangit.shopos.dao.FavoritesGoodsMapper;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dto.CollectGoodsDTO;
import com.wuliangit.shopos.entity.FavoritesGoods;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.Member;
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

    @Override
    public ArrayList<CollectGoodsDTO> getCollectGoodsList() {
        Member user = WebUtil.getCurrentMember();
        ArrayList<CollectGoodsDTO> collectGoods = favoritesGoodsMapper.getCollectGoodsList(user.getMemberId());
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
        return goodsMapper.deleteCollectGoods(goodsId,user.getMemberId());
    }
}
