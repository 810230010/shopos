package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.entity.AdminLog;
import com.wuliangit.shopos.service.AdminLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/5/15.
 */

@Service
public class AdminLogServiceImpl implements AdminLogService {
    @Override
    public List<AdminLog> getAdminLogList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        return null;
    }
}
