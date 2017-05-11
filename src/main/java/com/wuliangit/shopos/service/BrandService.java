package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.model.StoreAddBrand;
import com.wuliangit.shopos.model.StoreBrand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JangJanPing on 2017/4/15.
 */

public interface BrandService {
    /**
     * 获取店铺的品牌信息
     * @param page
     * @param pageSize
     * @param searchKey
     * @param storeId
     * @return
     */
    List<StoreBrand> getStoreBrands(Integer page, Integer pageSize, String searchKey, Integer storeId);
    /**
     * 更改店铺某品牌上下架状态(店铺)
     * @param id
     * @param status
     * @return
     */
    int updateBrandStatus(Integer id, String status);

    /**
     * 删除店铺某个品牌 (店铺)
     * @param id
     * @return
     */
    int deleteStoreBrand(Integer id);

    /**
     * 店铺查询所有品牌
     * @return
     */
    ArrayList<Brand> getAllAvailableBrands();

    /**
     * 添加店铺申请入驻品牌记录
     * @param storeId
     * @param brandId
     * @return
     */
    int addStoreBrand(Integer storeId, Integer brandId);


    /*************************************/
    /**
     * 添加品牌
     * @param brand
     * @return
     */
    int addBrand(Brand brand);

    /**
     * 管理员查询所有审核通过品牌列表
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<Brand> adminSearchValidatedBrands(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    /**
     * 根据品牌ID查询品牌信息
     * @param brandId
     * @return
     */
    Brand getBrandById(Integer brandId);

    /**
     * 管理员修改品牌信息
     * @param brand
     * @return
     */
    int adminUpdateBrand(Brand brand);

    /**
     * 查询品牌名是否存在
     * @param brandName
     * @return
     */
    boolean hasBrandName(String brandName);

    /**
     * 管理员删除品牌
     * @param brandId
     * @return
     */
    int adminDeleteBrandByID(Integer brandId);

    /**
     * 管理员查询待审核的店铺品牌
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<StoreAddBrand> adminSearchNewAddBrands(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    /**
     * 管理员更新店铺申请添加的品牌状态
     * @param brandId
     * @param status
     * @return
     */
    int adminUpdateAddBrandStatus(Integer brandId, String status);

    /**
     * 管理员更改店铺申请入驻品牌状态
     * @param id
     * @param status
     * @return
     */
    int adminUpdateStoreJoinBrand(Integer id, String status);

    /**
     * 管理员获取店铺申请入驻品牌列表
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<StoreAddBrand> adminGetStoreJoinBrands(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);
}
