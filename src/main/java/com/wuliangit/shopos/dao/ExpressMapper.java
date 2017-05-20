package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Express;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nilme on 2017/5/19.
 */
public interface ExpressMapper extends BaseMapper<Express, Integer> {
    /**
     * 获取快递公司信息
     * @return
     * @param searchKey
     */
    List<Express> getExpressList(@Param("searchKey") String searchKey);
}
