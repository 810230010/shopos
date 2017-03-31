package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/30.
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order) {
        return null;
    }
}
