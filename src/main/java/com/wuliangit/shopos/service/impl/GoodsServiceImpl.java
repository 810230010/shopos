package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/30.
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order) {
        return null;
    }

    @Override
    @Transactional
    public int createGoods(Goods goods, String skuStr) {
        StoreMin store = WebUtil.getCurrentStore();

        int res = goodsMapper.insertSelective(goods);


        return 0;
    }
}
