package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.Permission;

import java.util.List;

/**
 * Created by nilme on 2017/5/12.
 */
public interface PermissionMapper extends BaseMapper<Permission, Integer> {

    /**
     * 获取管理员菜单
     * @param adminId
     * @return
     */
    List<MenuDTO> getAdminMenus(Integer adminId);

    /**
     * 获取店铺菜单
     * @param sellerId
     * @return
     */
    List<MenuDTO> getStoreMenus(Integer sellerId);
}
