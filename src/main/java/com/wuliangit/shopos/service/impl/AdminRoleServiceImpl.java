package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.AdminRoleMapper;
import com.wuliangit.shopos.entity.AdminRole;
import com.wuliangit.shopos.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nilme on 2017/5/16.
 */

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public AdminRole getRoleByAdminId(Integer adminId) {
        return null;
    }

    @Override
    public AdminRole getRoleById(Integer adminRoleId) {
        return adminRoleMapper.selectByPrimaryKey(adminRoleId);
    }
}
