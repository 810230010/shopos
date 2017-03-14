package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.AdminLog;

public interface AdminLogMapper {
    int deleteByPrimaryKey(Integer adminLogId);

    int insert(AdminLog record);

    int insertSelective(AdminLog record);

    AdminLog selectByPrimaryKey(Integer adminLogId);

    int updateByPrimaryKeySelective(AdminLog record);

    int updateByPrimaryKey(AdminLog record);
}