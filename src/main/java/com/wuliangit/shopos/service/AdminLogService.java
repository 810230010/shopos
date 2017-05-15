package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.AdminLog;

import java.util.List;

/**
 * Created by nilme on 2017/5/15.
 */
public interface AdminLogService {
    /**
     * 获取管理员日志
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<AdminLog> getAdminLogList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);
}
