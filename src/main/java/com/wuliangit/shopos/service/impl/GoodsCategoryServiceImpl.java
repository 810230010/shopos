package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.GoodsCategoryMapper;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/4/11.
 */

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> getAllGoodsCategoryList() {
        return goodsCategoryMapper.selectAll();
    }

    @Override
    public int createGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryMapper.insertSelective(goodsCategory);
    }

    @Override
    public ArrayList<GoodsCategory> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType, Integer parentId) {
        PageHelper.startPage(page, pageSize);
        ArrayList<GoodsCategory> goodsCategories = goodsCategoryMapper.search(searchKey, orderColumn, orderType, parentId);
        return goodsCategories;
    }

    @Override
    public GoodsCategory getById(Integer goodsCategoryId) {
        return goodsCategoryMapper.selectByPrimaryKey(goodsCategoryId);
    }
}
