package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.SellerDTO;
import com.wuliangit.shopos.entity.Seller;

import java.util.List;
import java.util.Set;

/**
 * Created by nilme on 2017/5/15.
 */
public interface SellerService {
    /**
     * 通过用户名获取卖家信息
     * @param username
     * @return
     */
    Seller getByUsername(String username);

    /**
     * 通过用户ID获取卖家信息
     * @param sellerId
     * @return
     */
    Seller getById(Integer sellerId);

    /**
     * 获取卖家角色
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 获取卖家权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 更新用户信息
     * @param seller
     * @param newPass
     * @return
     */
    int update(SellerDTO seller, String newPass);

    /**
     * @Description: 获取所有的卖家
     * @Author: pangweichao
     * @Date: 23:23 2017/5/18
     * @Param: []
     * @return: java.util.List<com.wuliangit.shopos.entity.Seller>
     */
    List<Seller> getAllSeller();
}
