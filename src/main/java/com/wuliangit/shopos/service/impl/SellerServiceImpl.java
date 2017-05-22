package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.SellerMapper;
import com.wuliangit.shopos.dto.SellerDTO;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.SellerService;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nilme on 2017/5/15.
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private Mapper mapper;

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

    @Override
    public int update(SellerDTO seller, String newPass) {
        Seller currentSeller = WebUtil.getCurrentSeller();

        if (!StringUtils.isEmpty(seller.getEmail())) {
            currentSeller.setEmail(seller.getEmail());
        }

        if (!StringUtils.isEmpty(seller.getPhoto())) {
            currentSeller.setPhoto(seller.getPhoto());
        }

        //更新密码
        if (!StringUtils.isEmpty(newPass)) {
            currentSeller.setPassword(PasswordHelper.generatePassword(newPass, currentSeller.getSalt()));
        }
        int res = sellerMapper.updateByPrimaryKeySelective(currentSeller);

        //更新缓存
        WebUtil.getSession().removeAttribute(CoreConstants.SESSION_CURRENT_SELLER);
        WebUtil.getSession().setAttribute(CoreConstants.SESSION_CURRENT_SELLER, currentSeller);

        return res;
    }

    @Override
    public List<Seller> getAllSeller() {
        return sellerMapper.getAllSeller();
    }

    @Override
    public int createSeller(Seller seller) {
        return sellerMapper.insertSelective(seller);
    }
}
