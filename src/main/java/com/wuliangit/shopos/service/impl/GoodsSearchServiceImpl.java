package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.ChineseAnalysis;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dao.GoodsSearchMapper;
import com.wuliangit.shopos.dto.api.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.GoodsSearchDTO;
import com.wuliangit.shopos.service.GoodsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 搜索服务（后面可能改为lucence搜索）
 * Created by nilme on 2017/4/4.
 */

@Service
public class GoodsSearchServiceImpl implements GoodsSearchService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsSearchMapper goodsSearchMapper;

    private static String[] orderList = {"g.salenum", "g.collect", "g.evaluationGoodStar", "g.click", "g.evaluationCount"};

    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page,
                                                     Integer pageSize,
                                                     String searchKey,
                                                     String orderType,
                                                     Integer brandId,
                                                     Integer goodsCategoryId,
                                                     Integer storeId,
                                                     Integer storeGoodsCategoryId,
                                                     String type, Double lng, Double lat) {
        PageHelper.startPage(page, pageSize);

        searchKey = ChineseAnalysis.segment(searchKey);
        String order = this.createOrder(orderType, lng, lat);

        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.apiGoodsSearch(searchKey, order, brandId, goodsCategoryId, storeId, storeGoodsCategoryId, type, lng, lat);
        return goodses;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> directSellingSearch(GoodsSearchDTO goodsSearchDTO) {
        PageHelper.startPage(goodsSearchDTO.getPage(), goodsSearchDTO.getPageSize());

        goodsSearchDTO.setSearchKey(ChineseAnalysis.segment(goodsSearchDTO.getSearchKey()));
        String order = this.createOrder(goodsSearchDTO.getOrderType(), goodsSearchDTO.getLng(), goodsSearchDTO.getLat());

        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.goodsTypeSearch(goodsSearchDTO.getSearchKey(),
                order, "GOODS_TYPE_DIRECTSELLING", goodsSearchDTO.getLng(), goodsSearchDTO.getLng());

        return goodses;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> newGoodsSearch(GoodsSearchDTO goodsSearchDTO) {
        PageHelper.startPage(goodsSearchDTO.getPage(), goodsSearchDTO.getPageSize());

        goodsSearchDTO.setSearchKey(ChineseAnalysis.segment(goodsSearchDTO.getSearchKey()));
        String order = this.createOrder(goodsSearchDTO.getOrderType(), goodsSearchDTO.getLng(), goodsSearchDTO.getLat());
        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.goodsTypeSearch(goodsSearchDTO.getSearchKey(), order,
                "GOODS_TYPE_NEWGOODS", goodsSearchDTO.getLng(), goodsSearchDTO.getLng());
        return goodses;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> activityGoodsSearch(GoodsSearchDTO goodsSearchDTO) {
        PageHelper.startPage(goodsSearchDTO.getPage(), goodsSearchDTO.getPageSize());

        goodsSearchDTO.setSearchKey(ChineseAnalysis.segment(goodsSearchDTO.getSearchKey()));
        String order = this.createOrder(goodsSearchDTO.getOrderType(), goodsSearchDTO.getLng(), goodsSearchDTO.getLat());
        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.goodsTypeSearch(goodsSearchDTO.getSearchKey(), order,
                "GOODS_TYPE_ACTIVITY", goodsSearchDTO.getLng(), goodsSearchDTO.getLng());
        return goodses;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> seckillGoodsSearch(GoodsSearchDTO goodsSearchDTO) {
        PageHelper.startPage(goodsSearchDTO.getPage(), goodsSearchDTO.getPageSize());

        goodsSearchDTO.setSearchKey(ChineseAnalysis.segment(goodsSearchDTO.getSearchKey()));
        String order = this.createOrder(goodsSearchDTO.getOrderType(), goodsSearchDTO.getLng(), goodsSearchDTO.getLat());
        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.goodsTypeSearch(goodsSearchDTO.getSearchKey(), order,
                "GOODS_TYPE_SECKILL", goodsSearchDTO.getLng(), goodsSearchDTO.getLng());
        return goodses;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> normalGoodsSearch(GoodsSearchDTO goodsSearchDTO) {
        PageHelper.startPage(goodsSearchDTO.getPage(), goodsSearchDTO.getPageSize());

        goodsSearchDTO.setSearchKey(ChineseAnalysis.segment(goodsSearchDTO.getSearchKey()));
        String order = this.createOrder(goodsSearchDTO.getOrderType(), goodsSearchDTO.getLng(), goodsSearchDTO.getLat());
        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.goodsTypeSearch(goodsSearchDTO.getSearchKey(), order,
                "GOODS_TYPE_NORMAL", goodsSearchDTO.getLng(), goodsSearchDTO.getLng());
        return goodses;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> indexGoods() {
        ArrayList<ApiGoodsListDTO> indexGoods = goodsSearchMapper.indexGoods();
        return indexGoods;
    }

    @Override
    public ArrayList<ApiGoodsListDTO> secondHandSearch(GoodsSearchDTO goodsSearchDTO) {
        PageHelper.startPage(goodsSearchDTO.getPage(), goodsSearchDTO.getPageSize());

        goodsSearchDTO.setSearchKey(ChineseAnalysis.segment(goodsSearchDTO.getSearchKey()));
        String order = this.createOrder(goodsSearchDTO.getOrderType(), goodsSearchDTO.getLng(), goodsSearchDTO.getLat());
        ArrayList<ApiGoodsListDTO> goodses = goodsSearchMapper.goodsTypeSearch(goodsSearchDTO.getSearchKey(), order,
                "SECOND_HAND", goodsSearchDTO.getLng(), goodsSearchDTO.getLng());
        return goodses;
    }

    /**
     * 拼接排序参数
     *
     * @param primaryOrder 主排序参数
     * @return
     */
    private String createOrder(String primaryOrder, Double lng, Double lat) {
        StringBuilder order = new StringBuilder();

        if (primaryOrder == null) {
            primaryOrder = "salenum";
        }

        switch (primaryOrder) {
            case "priceAsc":
                order.append("g.price").append(" asc");
                break;
            case "priceDesc":
                order.append("g.price").append(" desc");
                break;
            case "distance":
                if (lng != null && lat != null && !lng.equals(0) && !lat.equals(0)) {
                    order.append("distance").append(" asc");
                }else{
                    order.append("g.collect").append(" asc");
                }
                break;
            default:
                primaryOrder = StringUtils.camelToUnderline(primaryOrder);
                order.append(primaryOrder).append(" desc");
        }

        for (String orderKey : orderList) {
            if (!primaryOrder.equals(orderKey)) {
                order.append(",").append(StringUtils.camelToUnderline(orderKey)).append(" desc");
            }
        }
        return order.toString();
    }

}
