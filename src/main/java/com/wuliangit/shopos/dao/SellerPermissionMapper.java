package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.SellerPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nilme on 2017/5/12.
 */
public interface SellerPermissionMapper extends BaseMapper<SellerPermission, Integer> {

    /**
     * 获取店铺菜单
     * @param permissionList
     * @return
     */
    List<MenuDTO> getStoreMenus(@Param("permissionList") String permissionList);

}
