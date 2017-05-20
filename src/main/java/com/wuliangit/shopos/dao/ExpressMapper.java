package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Express;

import java.util.List;

/**
 * Created by nilme on 2017/5/19.
 */
public interface ExpressMapper extends BaseMapper<Express, Integer> {
    /**
     * 获取快递公司信息
     * @return
     */
    List<Express> getExpressList();
}
