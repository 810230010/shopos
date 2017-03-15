package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.core.dao.BaseMapper;
import com.wuliangit.shopos.entity.Admin;

public interface AdminMapper extends BaseMapper<Admin, Integer> {
    Admin getByUsername(String username);
}