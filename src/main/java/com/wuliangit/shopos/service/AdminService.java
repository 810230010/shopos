package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Admin;

import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */
public interface AdminService {
    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);

    Admin getByUsername(String username);
}
