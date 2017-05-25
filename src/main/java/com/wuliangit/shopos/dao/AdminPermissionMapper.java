package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.AdminPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionMapper extends BaseMapper<AdminPermission, Integer> {
    /**
     * 获取当前管理员菜单
     * @param permissionList
     * @return
     */
    List<MenuDTO> getAdminMenus(@Param("permissionList") String permissionList);

    String getAdminPermissionsByRoleId(@Param("adminRoleId") Integer adminRoleId);
}