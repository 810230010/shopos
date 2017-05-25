package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.AdminRole;

import java.util.List;

/**
 * Created by nilme on 2017/5/16.
 */
public interface AdminRoleService {
    /**
     * 管理员通过id获取角色
     * @param adminId
     * @return
     */
    AdminRole getRoleByAdminId(Integer adminId);

    /**
     * 通过id获取
     * @param adminRoleId
     * @return
     */
    AdminRole getRoleById(Integer adminRoleId);

    /**
     * 查询所有管理员角色列表
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<AdminRoleDTO> searchAdminRoleList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * 删除管理员角色
     * @param adminRoleId
     * @return
     */
    int deleteRole(Integer adminRoleId);


    /**
     * 得到管理员角色详情
     * @param roleId
     * @return
     */
    AdminRoleDTO getAdminRoleDetail(Integer roleId);

    int addAdminRole(AdminRole adminRole);
}
