package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface AdminMapper extends BaseMapper<Admin, Integer> {

    /**
     * 通过用户名获取管理员
     * @param username
     * @return
     */
    Admin getByUsername(String username);

    /**
     * 获取所有管理员列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<AdminDTO> searchAdminList(@Param("searchKey") String searchKey,
                                   @Param("orderColumn") String orderColumn,
                                   @Param("orderType")String orderType);

    /**
     * 获得所有可用管理员角色列表
     * @return
     */
    ArrayList<AdminRoleDTO> getAdminRoles();

    /**
     * 查询管理员是否存在
     * @param username
     * @return
     */
    Admin getAdminByUsername(@Param("username") String username);

    AdminDTO getAdminById(@Param("adminId") Integer adminId);

}