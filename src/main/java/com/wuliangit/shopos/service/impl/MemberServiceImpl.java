package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.MemberAdviceMapper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dto.MemberAuthListDTO;
import com.wuliangit.shopos.dto.MemberListDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.MemberAdvice;
import com.wuliangit.shopos.service.MemberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<MemberListDTO> getMemberList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page,pageSize);
        List<MemberListDTO> result = memberMapper.getMemberList(orderColumn,orderType,searchKey);
        return result;
    }

    @Override
    public Integer deleteMember(Integer memberId) {
        return memberMapper.deleteMember(memberId);
    }

    public Integer updateMemberAuthState(Integer memberId, boolean isCheck) {
        Member member = memberMapper.selectByPrimaryKey(memberId);
        if (isCheck){
            member.setAuthState(POJOConstants.AUTHED);
        }else{
            member.setAuthState(POJOConstants.REAUTH);
        }
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public List<MemberAuthListDTO> getMemberAuthList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page,pageSize);
        List<MemberAuthListDTO> result = memberMapper.getMemberAuthList(orderColumn,orderType,searchKey);
        return result;
    }
}
