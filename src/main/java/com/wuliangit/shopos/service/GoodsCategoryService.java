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
    ArrayList<GoodsCategory> AdminSearch(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType, Integer parentId);

    /**
     * 通过id获取商品分类
     * @param goodsCategoryId
     * @return
     */
    GoodsCategory getById(Integer goodsCategoryId);

    /**
     * 更新商品分类
     * @param goodsCategory
     * @return
     */
    int updateGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 删除商品分类
     * @param goodsCategoryId
     * @return
     */
    int deleteCategory(Integer goodsCategoryId);

    /**
     * 通过父类获取商品分类
     * @param parentId
     * @return
     */
    List<GoodsCategory> getGoodsCategoryListByParentId(Integer parentId);
}
