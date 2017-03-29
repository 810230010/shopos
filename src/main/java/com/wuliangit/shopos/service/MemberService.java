package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Member;

import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */
public interface MemberService {
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
     * 通过openid获取会员用户
     * @param openid
     * @return
     */
    Member getByOpenid(String openid);

    /**
     * 通过用户名获取会员用户
     * @param username
     * @return
     */
    Member getByUsername(String username);

    /**
     * 保存会员用户
     * @param member
     * @return
     */
    int createMember(Member member);

    /**
     * 更新用户信息
     * @param member
     * @return
     */
    int updateMember(Member member);
}
