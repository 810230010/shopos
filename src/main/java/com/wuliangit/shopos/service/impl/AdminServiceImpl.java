package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.AdminMapper;
import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        return roles;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }

    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    @Override
    public List<AdminDTO> searchAdminList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page, pageSize);
        return adminMapper.searchAdminList(searchKey, orderColumn, orderType);
    }

    @Override
    public ArrayList<AdminRoleDTO> getAllAdminRoles() {
        return adminMapper.getAdminRoles();
    }

    @Override
    public int createAdmin(Admin admin) {
        return adminMapper.insertSelective(admin);
    }

    @Override
    public AdminDTO getAdminById(Integer adminId) {
        return adminMapper.getAdminById(adminId);
    }
}
