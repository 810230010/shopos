package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Seller;

import java.util.List;

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

    /**
     * @Description: 获取所有的卖家
     * @Author: pangweichao
     * @Date: 23:23 2017/5/18
     * @Param: []
     * @return: java.util.List<com.wuliangit.shopos.entity.Seller>
     */
    List<Seller> getAllSeller();
}
