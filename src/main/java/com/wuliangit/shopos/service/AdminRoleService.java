package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.AdminRole;

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
}
