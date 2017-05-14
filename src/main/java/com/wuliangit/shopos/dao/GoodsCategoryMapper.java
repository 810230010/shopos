package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiGoodsCategoryDOT;
import com.wuliangit.shopos.dto.ApiGoodsCategoryWithChildDTO;
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
    ArrayList<GoodsCategory> AdminSearch(@Param("searchKey") String searchKey,
                                    @Param("orderColumn") String orderColumn,
                                    @Param("orderType")String orderType,
                                    @Param("parentId")Integer parentId);


    /**
     * 通过父类获取商品分类
     * @param parentId
     * @return
     */
    List<GoodsCategory> getGoodsCategoryListByParentId(Integer parentId);

    /**
     * 移动端接口获取一级分类
     * @return
     */
    List<ApiGoodsCategoryDOT> getGoodsCategoryDTOByParentId(Integer parentId);

    /**
     * 获取二级分类
     * @param parentId
     * @return
     */
    List<ApiGoodsCategoryWithChildDTO> getGoodsCategoryLevelSecond(Integer parentId);
}