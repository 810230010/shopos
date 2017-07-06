package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.GoodsCategoryMapper;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dao.GoodsSkuMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.dto.GoodsDetailDTO;
import com.wuliangit.shopos.dto.api.ApiGoodsDTO;
import com.wuliangit.shopos.dto.api.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.api.ApiSellerInfo;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private StoreService storeService;
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order) {
        return null;
    }

    @Override
    @Transactional
    public int createGoods(Goods goods, String skuStr) {
        Store store = storeMapper.selectByPrimaryKey(WebUtil.getCurrentStore().getStoreId());

        goods.setStoreId(store.getStoreId());
        goods.setCreateTime(new Date());
        goods.setStoreName(store.getName());
        goods.setEditTime(new Date());

        goods.setUploadFrom(POJOConstants.GOODS_FROM_COMPUTER);

        if (store.getStoreId().equals(1)) {
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
    public ArrayList<Goods> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        StoreMin currentStore = WebUtil.getCurrentStore();
        ArrayList<Goods> goodses = goodsMapper.StoreSearch(currentStore.getStoreId(), searchKey, orderColumn, orderType);
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
        goods.setUploadFrom(POJOConstants.GOODS_FROM_PHONE);
        goods.setUnit(unit);
        goods.setGoodsBody(goodsBody);
        goods.setAdWord("");
        goods.setCommission(new BigDecimal(0));
        goods.setMarketprice(new BigDecimal(0));
        goods.setAttrs("[{\"name\":\"商品\",\"isImg\":false,\"values\":[{\"name\":\""+goods.getName()+"\"}]}]");

        //处理图片
        String[] split = images.split("&&");

        StringBuilder bs = new StringBuilder();
        int flag = 0;
        for (String s : split) {
            if (flag==0){
                bs.append(QiNiuUtils.getBaseUrl()).append(s);
                goods.setTitleImg(QiNiuUtils.getBaseUrl()+s);
                flag= 1;
            }else{
                bs.append("&&").append(QiNiuUtils.getBaseUrl()).append(s);
            }

        }

        goods.setImages(bs.toString());

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

    @Override
    public ApiGoodsDTO apiGetGoodsDTOById(Integer goodsId) {
        ApiGoodsDTO goodsDTO = goodsMapper.apiGetGoodsDTOById(goodsId);

        //设置商品类别
        goodsDTO.setGoodsCategory1(goodsCategoryMapper.selectByPrimaryKey(goodsDTO.getGoodsCategory1Id()).getName());
        goodsDTO.setGoodsCategory2(goodsCategoryMapper.selectByPrimaryKey(goodsDTO.getGoodsCategory2Id()).getName());
        goodsDTO.setGoodsCategory3(goodsCategoryMapper.selectByPrimaryKey(goodsDTO.getGoodsCategory3Id()).getName());

        Store store = storeMapper.selectByPrimaryKey(goodsDTO.getStoreId());
        goodsDTO.setStoreLogo(store.getLogo());
        if (!StringUtils.isEmpty(store.getAreaInfo())){
            goodsDTO.setArea(store.getAreaInfo());
        }
        return goodsDTO;
    }

    @Override
    @Transactional
    public int apiUpdateGoods(Integer goodsId, Integer goodsCategory1Id, Integer goodsCategory2Id, Integer goodsCategory3Id, String name, BigDecimal price, BigDecimal carriage, Integer storage, String type, String unit, String goodsBody, String images) {
        Member member = WebUtil.getCurrentMember();
        Store store = storeMapper.getStoreByBindMemberUsername(member.getUsername());
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);

        if (!goods.getStoreId().equals(store.getStoreId())){
            return 0;
        }

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

        //处理图片
        String[] split = images.split("&&");

        StringBuilder bs = new StringBuilder();
        int flag = 0;
        for (String s : split) {
            if (flag==0){
                bs.append(QiNiuUtils.getBaseUrl()).append(s);
                goods.setTitleImg(QiNiuUtils.getBaseUrl()+s);
                flag= 1;
            }else{
                bs.append("&&").append(QiNiuUtils.getBaseUrl()).append(s);
            }

        }

        goods.setImages(bs.toString());
        goods.setEditTime(new Date());

        int res = goodsMapper.updateByPrimaryKeySelective(goods);

        List<GoodsSku> goodsSkus = goodsSkuMapper.getGoodsSkuByGoodsId(goods.getGoodsId());
        //移动端上传的坑定只有一个sku
        GoodsSku goodsSku = goodsSkus.get(0);
        goodsSku.setSkuPrice(price);
        goodsSku.setSkuStock(storage);
        goodsSku.setSkuValue(name);
        goodsSkuMapper.updateByPrimaryKeySelective(goodsSku);

        return res;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> sellerGetGoodsCanEdit(Integer page, Integer pageSize) {
        ApiSellerInfo sellerInfo = storeService.getSellerInfo();
        ArrayList<ApiGoodsListDTO> goodses = goodsMapper.sellerGetGoodsCanEdit(sellerInfo.getStoreId());
        return goodses;
    }

    @Override
    public List<Goods> adminGetAllGoodsSearch(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        return goodsMapper.adminGetGoodsSearch(searchKey, orderColumn, orderType);
    }

    @Override
    public int adminUpdateGoodsApplyStatus(Integer goodsId, String reason, Integer type) {
        return goodsMapper.updateGoodsApplyStatus(goodsId, reason, type);
    }

    @Override
    public GoodsDetailDTO adminGetGoodsDetail(Integer goodsId) {
        GoodsDetailDTO goodsDetailDTO = goodsMapper.adminGetGoodsDetail(goodsId);
        if(goodsDetailDTO.getImages().contains(",")){
            goodsDetailDTO.setImageSet(goodsDetailDTO.getImages().split(","));
        }else{
            goodsDetailDTO.setImageSet(new String[]{goodsDetailDTO.getImages()});
        }
        return goodsDetailDTO;
    }

    @Override
    public int updateGoodsOnshelfStatus(Integer goodsId, Integer type) {
        return goodsMapper.updateGoodsOnshelfStatus(goodsId, type);
    }
}
