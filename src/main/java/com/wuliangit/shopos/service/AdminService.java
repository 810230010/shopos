package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Admin;

import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */
public interface AdminService {
    /**
     * 获取角色
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 获取权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 通过用户名查找管理员
     * @param username
     * @return
     */
    Admin getByUsername(String username);
}
