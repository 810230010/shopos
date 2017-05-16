package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.SellerRole;

/**
 * Created by nilme on 2017/5/16.
 */
public interface SellerRoleService {
    /**
     * 通过id获取卖家角色
     * @param sellerRoleId
     * @return
     */
    SellerRole getRoleServiceById(Integer sellerRoleId);
}
