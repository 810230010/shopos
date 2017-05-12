package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.PermissionMapper;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.service.PerminssionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/5/12.
 */

@Service
public class PerminssionServiceImpl implements PerminssionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<MenuDTO> getAdminMenus() {

        Admin admin = WebUtil.getCurrentAdmin();

//        List<MenuDTO> menus = permissionMapper.getAdminMenus(admin.getAdminId());
//
//        List<MenuDTO> menuList = handleSubType(menus, 0);

        return null;
    }
}
