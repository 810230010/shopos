package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.AdminRoleMapper;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.entity.AdminRole;
import com.wuliangit.shopos.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<AdminRoleDTO> searchAdminRoleList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page, pageSize);
        return adminRoleMapper.searchAdminRoleList(searchKey, orderColumn, orderType);
    }

    @Override
    public int deleteRole(Integer adminRoleId) {
        return adminRoleMapper.deleteByPrimaryKey(adminRoleId);
    }
}
