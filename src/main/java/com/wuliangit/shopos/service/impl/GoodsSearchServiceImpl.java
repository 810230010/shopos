package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
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


    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page,
                                                     Integer pageSize,
                                                     String searchKey,
                                                     String order,
                                                     Integer brandId,
                                                     Integer goodsCategoryId,
                                                     Integer storeId,
                                                     Integer storeGoodsCategoryId,
                                                     String type) {
        PageHelper.startPage(page, pageSize);
        ArrayList<ApiGoodsListDTO> goodses = goodsMapper.apiGoodsSearch(searchKey, order, brandId, goodsCategoryId, storeId, storeGoodsCategoryId, type);
        return goodses;
    }
}
