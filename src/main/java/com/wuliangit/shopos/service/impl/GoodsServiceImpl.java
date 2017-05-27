package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dao.GoodsSkuMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.event.PrintJobAttributeEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nilme on 2017/3/30.
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order) {
        return null;
    }

    @Override
    @Transactional
    public int createGoods(Goods goods, String skuStr) {
        StoreMin store = WebUtil.getCurrentStore();

        goods.setStoreId(store.getStoreId());
        goods.setCreateTime(new Date());
        goods.setStoreName(store.getName());
        goods.setEditTime(new Date());

        if (store.getStoreId().equals(0)) {
            goods.setIsPlatform(true);
        } else {
            goods.setIsPlatform(false);
        }

        int res = goodsMapper.insertSelective(goods);

        //解析sku的json数据
        Gson gson = new Gson();
        List<GoodsSku> skus = gson.fromJson(skuStr, new TypeToken<List<GoodsSku>>() {
        }.getType());

        for (GoodsSku sku : skus) {
            sku.setGoodsId(goods.getGoodsId());
            goodsSkuMapper.insertSelective(sku);
        }

        return res;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }

    @Override
    public List<GoodsSku> getGoodsSkuByGoodsId(Integer goodsId) {
        return goodsSkuMapper.getGoodsSkuByGoodsId(goodsId);
    }

    @Override
    public ArrayList<Goods> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType, Integer parentId) {
        PageHelper.startPage(page, pageSize);
        StoreMin currentStore = WebUtil.getCurrentStore();
        ArrayList<Goods> goodses = goodsMapper.StoreSearch(currentStore.getStoreId(), searchKey, orderColumn, orderType, parentId);
        return goodses;
    }

    @Override
    public int uodateGoods(Goods goods) {
        goods.setEditTime(new Date());
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    @Transactional
    public int deleteGoods(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        goods.setDelFlag(true);
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public StoreGoodsDetailDTO getSimplGoodsInfo(Integer goodsId) {
        return goodsMapper.getSimplGoodsInfo(goodsId);
    }

    @Override
    public Integer getGoodsCountByStoreId(Integer storeId) {
        return goodsMapper.getGoodsCountByStoreId(storeId);
    }

    @Override
    @Transactional
    public int apiCreateGooods(Integer goodsCategory1Id, Integer goodsCategory2Id, Integer goodsCategory3Id,
                               String name, BigDecimal price, BigDecimal carriage, Integer storage,
                               String type, String unit, String goodsBody, String images) {
        Goods goods = new Goods();
        goods.setGoodsCategory1Id(goodsCategory1Id);
        goods.setGoodsCategory2Id(goodsCategory2Id);
        goods.setGoodsCategory3Id(goodsCategory3Id);
        goods.setName(name);
        goods.setPrice(price);
        goods.setCarriage(carriage);
        goods.setStorage(storage);
        goods.setType(type);
        goods.setUnit(unit);
        goods.setGoodsBody(goodsBody);
        goods.setAdWord("");
        goods.setCommission(new BigDecimal(0));
        goods.setMarketprice(new BigDecimal(0));
        goods.setAttrs("[]");

        //处理图片
        String[] split = images.split("##");
        goods.setTitleImg(split[0]);
        goods.setImages(images);

        Member member = WebUtil.getCurrentMember();

        Store store = storeMapper.getStoreByBindMemberUsername(member.getUsername());

        goods.setStoreId(store.getStoreId());
        goods.setCreateTime(new Date());
        goods.setStoreName(store.getName());
        goods.setEditTime(new Date());

        if (store.getStoreId().equals(1)) {
            goods.setIsPlatform(true);
        } else {
            goods.setIsPlatform(false);
        }
        int res = goodsMapper.insertSelective(goods);

        //添加sku
        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setGoodsId(goods.getGoodsId());
        goodsSku.setSkuPrice(price);
        goodsSku.setSkuStock(storage);
        goodsSku.setSkuValue(name);
        goodsSkuMapper.insertSelective(goodsSku);

        return res;
    }
}
