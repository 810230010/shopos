package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.core.dao.BaseMapper;
import com.wuliangit.shopos.entity.Admin;

public interface AdminMapper extends BaseMapper<Admin, Integer> {

    /**
     * 通过用户名获取管理员
     * @param username
     * @return
     */
    Admin getByUsername(String username);
}