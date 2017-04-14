package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory, Integer> {

    /**
     * 获取所有商品分类
     * @return
     */
    List<GoodsCategory> selectAll();

    /**
     * 后台列表搜索
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param parentId
     * @return
     */
    ArrayList<GoodsCategory> search(@Param("searchKey") String searchKey,
                                    @Param("orderColumn") String orderColumn,
                                    @Param("orderType")String orderType,
                                    @Param("parentId")Integer parentId);


}