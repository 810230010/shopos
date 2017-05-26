package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.AdminLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminLogMapper extends BaseMapper<AdminLog, Integer> {
    /**
     * 查询管理员日志
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<AdminLog> selectAdminLogs(@Param("orderColumn") String orderColumn, @Param("orderType")String orderType, @Param("searchKey")String searchKey);
}