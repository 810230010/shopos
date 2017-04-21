package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @Author JangJanPing
 * @Description 品牌Mapper
 */
public interface BrandMapper extends BaseMapper<Brand, Integer> {
     //获取后台品牌查询列表
     ArrayList<Brand> search(@Param("searchKey") String searchKey,
                                     @Param("orderColumn") String orderColumn,
                                     @Param("orderType")String orderType);
     //根据分类名称查询分类id
     int queryCategoryIdByName(@Param("name") String categoryName);

     //查询品牌名是否存在
    Brand queryBrandName(@Param("brandName") String brandName);
}