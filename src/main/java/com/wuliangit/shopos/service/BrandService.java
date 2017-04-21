package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by JangJanPing on 2017/4/15.
 */

public interface BrandService {
    //添加品牌
    int addBrand(Brand brand);

    //查询列表
    ArrayList<Brand> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    //根据品牌ID查询品牌信息
    Brand getBrandById(Integer brandId);

    //修改品牌信息
    int updateBrand(Brand brand);

    //查询品牌名是否存在
    boolean hasBrandName(String brandName);

    //删除品牌
    int deleteBrandByID(Integer brandId);
}
