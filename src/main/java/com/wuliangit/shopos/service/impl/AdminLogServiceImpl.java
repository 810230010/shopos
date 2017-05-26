package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.AdminLogMapper;
import com.wuliangit.shopos.entity.AdminLog;
import com.wuliangit.shopos.service.AdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/5/15.
 */

@Service
public class AdminLogServiceImpl implements AdminLogService {
    @Autowired
    private AdminLogMapper adminLogMapper;
    @Override
    public List<AdminLog> getAdminLogList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page, pageSize);
        return adminLogMapper.selectAdminLogs(orderColumn, orderType, searchKey);
    }
}
