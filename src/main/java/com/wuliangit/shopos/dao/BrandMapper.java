package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.model.StoreAddBrand;
import com.wuliangit.shopos.model.StoreBrand;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JangJanPing
 * @Description 品牌Mapper
 */
public interface BrandMapper extends BaseMapper<Brand, Integer> {

    /**
     * 获得某个店铺品牌
     * @param storeId
     * @return
     */
    List<StoreBrand> getStoreBrands(@Param("storeId") Integer storeId, @Param("searchKey") String searchKey);

    /**
     * 更改店铺某品牌上下架状态
     * @param id
     * @param status
     * @return
     */
    int updateBrandStatusByPrimaryKey(@Param("id") Integer id, @Param("status") String status);

    /**
     * 删除某个店铺的品牌
     * @param id
     * @return
     */
    int deleteStoreBrand(@Param("id") Integer id);

    /**
     * 查询所有品牌
     * @return
     */
    ArrayList<Brand> queryAllBrands();

    /**
     * 店铺入驻品牌
     * @param storeId
     * @param brandId
     * @return
     */
    int addStoreBrand(@Param("storeId") Integer storeId, @Param("brandId") Integer brandId);
    /**
     *  获取后台品牌查询列表
     */
     ArrayList<Brand> search(@Param("searchKey") String searchKey,
                                     @Param("orderColumn") String orderColumn,
                                     @Param("orderType")String orderType);


    /**
     * 查询品牌名是否存在
     */
    Brand queryBrandName(@Param("brandName") String brandName);

    /**
     * 查询待审核的品牌列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<StoreAddBrand> searchBrands(@Param("searchKey") String searchKey,
                                          @Param("orderColumn") String orderColumn,
                                          @Param("orderType")String orderType);


    /**
     * 更改品牌申请
     * @param brandId
     * @param status
     * @return
     */
    int updateBrandStatus(@Param("brandId") Integer brandId, @Param("status") String status);

    /**
     * 更改店铺入驻品牌状态
     * @param id
     * @param status
     * @return
     */
    int updateStoreJoinBrandStatus(@Param("id") Integer id, @Param("status") String status);

    /**
     * 查询店铺申请入驻品牌列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<StoreAddBrand> getStoreJoinBrands(@Param("searchKey") String searchKey,
                                                @Param("orderColumn") String orderColumn,
                                                @Param("orderType")String orderType);
}