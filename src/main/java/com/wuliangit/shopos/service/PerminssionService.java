package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.MenuDTO;

import java.util.List;

/**
 * Created by nilme on 2017/5/12.
 */
public interface PerminssionService {

    /**
     * 获取管理员菜单
     * @return
     */
    List<MenuDTO> getAdminMenus();
}
