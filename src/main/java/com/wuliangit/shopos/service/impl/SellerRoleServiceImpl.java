package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.SellerRoleMapper;
import com.wuliangit.shopos.entity.SellerRole;
import com.wuliangit.shopos.service.SellerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nilme on 2017/5/16.
 */

@Service
public class SellerRoleServiceImpl implements SellerRoleService {

    @Autowired
    private SellerRoleMapper sellerRoleMapper;

    @Override
    public SellerRole getRoleServiceById(Integer sellerRoleId) {
        return sellerRoleMapper.selectByPrimaryKey(sellerRoleId);
    }
}
