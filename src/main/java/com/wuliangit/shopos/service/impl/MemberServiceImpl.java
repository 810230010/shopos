package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("user");
        return roles;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }

    @Override
    public Member getByOpenid(String openid) {
        return memberMapper.getByOpenid(openid);
    }

    @Override
    public Member getByUsername(String username) {
        return memberMapper.getByUsername(username);
    }

    @Override
    public int createMember(Member member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public int updateMember(Member member) {
        member.setUpdateTime(new Date());

        //更新缓存
        WebUtil.getSession().removeAttribute(CoreConstants.SESSION_CURRENT_USER);
        WebUtil.getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, member);

        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Object getByMemberId(Integer userId) {
        return memberMapper.selectByPrimaryKey(userId);
    }
}
