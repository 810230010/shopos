package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Member;

public interface MemberMapper extends BaseMapper<Member, Integer> {

    /**
     * 通过openid获取用户
     * @param openid
     * @return
     */
    Member getByOpenid(String openid);

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    Member getByUsername(String username);
}