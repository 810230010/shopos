package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.MemberAuthListDTO;
import com.wuliangit.shopos.dto.MemberListDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.MemberAdvice;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * 通过用户id获取用户
     * @param userId
     * @return
     */
    Member getByMemberId(Integer userId);

    /**
     * 获取会员列表数据
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<MemberListDTO> getMemberList(Integer page,Integer pageSize,String orderColumn,String orderType,String searchKey);

    /**
     * 删除会员
     * @param memberId
     * @return
     */
    Integer deleteMember(Integer memberId);

     /** 更改会员认证状态
     * @param memberId
     * @param isCheck
     * @return
     */
    Integer updateMemberAuthState(Integer memberId, boolean isCheck);

    /**
     * 获取待认证会员
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<MemberAuthListDTO> getMemberAuthList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * 更新用户GPS信息
     * @param longitude
     * @param latitude
     * @return
     */
    int uploadGPS(Double longitude, Double latitude);
}
