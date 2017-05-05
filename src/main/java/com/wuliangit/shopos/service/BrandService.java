package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.model.StoreAddBrand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by JangJanPing on 2017/4/15.
 */

public interface BrandService {
    /**
     * 添加品牌
     * @param brand
     * @return
     */
    int addBrand(Brand brand);

    /**
     * 查询列表
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<Brand> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    /**
     * 根据品牌ID查询品牌信息
     * @param brandId
     * @return
     */
    Brand getBrandById(Integer brandId);

    /**
     * 修改品牌信息
     * @param brand
     * @return
     */
    int updateBrand(Brand brand);

    /**
     * 查询品牌名是否存在
     * @param brandName
     * @return
     */
    boolean hasBrandName(String brandName);

    /**
     * 删除品牌
     * @param brandId
     * @return
     */
    int deleteBrandByID(Integer brandId);

    /**
     * 查询待审核的店铺品牌
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<StoreAddBrand> searchBrands(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

}
