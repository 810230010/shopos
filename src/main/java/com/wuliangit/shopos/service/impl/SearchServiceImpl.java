package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 搜索服务（后面可能改为lucence搜索）
 * Created by nilme on 2017/4/4.
 */

@Service
public class SearchServiceImpl implements SearchService {

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
                                                     Integer storeGoodsCategoryId) {



        return null;
    }
}