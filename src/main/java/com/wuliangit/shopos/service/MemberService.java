package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Member;

import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */
public interface MemberService {
    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);

    Member getUserByOpenid(String username);
}
