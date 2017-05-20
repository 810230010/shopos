package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Express;

import java.util.List;

/**
 * Created by nilme on 2017/5/19.
 */
public interface ExpressService {

    /**
     * 获取快递公司信息
     * @return
     * @param searchkey
     */
    List<Express> getExpressList(String searchkey);
}
