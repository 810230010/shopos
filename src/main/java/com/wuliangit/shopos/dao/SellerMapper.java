package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Seller;

/**
 * Created by nilme on 2017/5/12.
 */
public interface SellerMapper extends BaseMapper<Seller, Integer> {
    /**
     * 通过用户名获取卖家信息
     * @param username
     * @return
     */
    Seller getByUsername(String username);
}
