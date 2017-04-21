package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.BrandMapper;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by JangJanPing on 2017/4/15.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public ArrayList<Brand> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        return brandMapper.search(searchKey, orderColumn, orderType);
    }

    @Override
    public Brand getBrandById(Integer brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public boolean hasBrandName(String brandName) {
        if(brandMapper.queryBrandName(brandName) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteBrandByID(Integer brandId) {
        return brandMapper.deleteByPrimaryKey(brandId);
    }


}
