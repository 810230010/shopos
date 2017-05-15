package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.SellerMapper;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nilme on 2017/5/15.
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public Seller getByUsername(String username) {
        return sellerMapper.getByUsername(username);
    }

    @Override
    public Seller getById(Integer sellerId) {
        return sellerMapper.selectByPrimaryKey(sellerId);
    }

    @Override
    public Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("store");
        return roles;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }
}
