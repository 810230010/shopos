package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;

import java.util.ArrayList;

/**
 * 搜索服务
 * Created by nilme on 2017/4/4.
 */
public interface SearchService {

    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order, Integer brandId, Integer goodsCategoryId);
}
