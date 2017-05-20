package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
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

    private static String[] orderList = {"salenum", "collect", "evaluationGoodStar", "click", "evaluationCount"};

    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page,
                                                     Integer pageSize,
                                                     String searchKey,
                                                     String orderType,
                                                     Integer brandId,
                                                     Integer goodsCategoryId,
                                                     Integer storeId,
                                                     Integer storeGoodsCategoryId,
                                                     String type) {
        PageHelper.startPage(page, pageSize);

        String order = this.createOrder(orderType);

        ArrayList<ApiGoodsListDTO> goodses = goodsMapper.apiGoodsSearch(searchKey, order, brandId, goodsCategoryId, storeId, storeGoodsCategoryId, type);
        return goodses;
    }

    /**
     * 拼接排序参数
     * @param primaryOrder 主排序参数
     * @return
     */
    private String createOrder(String primaryOrder) {
        StringBuilder order = new StringBuilder();

        if (primaryOrder.endsWith("priceAsc")) {
            order.append("price").append(" asc");
        } else if (primaryOrder.endsWith("priceDesc")) {
            order.append("price").append(" desc");
        } else {
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
