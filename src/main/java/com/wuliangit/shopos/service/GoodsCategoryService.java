package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.GoodsCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/4/11.
 */
public interface GoodsCategoryService {

    /**
     * 获取所有商品分类
     * @return
     */
    List<GoodsCategory> getAllGoodsCategoryList();

    /**
     * 创建商品分类
     * @param goodsCategory
     * @return
     */
    int createGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 后台列表搜索
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param parentId
     * @return
     */
    ArrayList<GoodsCategory> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType, Integer parentId);

    /**
     * 通过id获取
     * @param goodsCategoryId
     * @return
     */
    GoodsCategory getById(Integer goodsCategoryId);
}
