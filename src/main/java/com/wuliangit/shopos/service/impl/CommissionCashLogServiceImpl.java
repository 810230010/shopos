package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.CommissionCashLogMapper;
import com.wuliangit.shopos.dto.TuikeOrderListDTO;
import com.wuliangit.shopos.entity.CommissionCashLog;
import com.wuliangit.shopos.service.CommissionCashLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/4.
 */
@Service
public class CommissionCashLogServiceImpl implements CommissionCashLogService {

    @Autowired
    private CommissionCashLogMapper commissionCashLogMapper;

    @Override
    public List<CommissionCashLog> getCommissionLogList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return commissionCashLogMapper.getCommissionLogList(searchKey,orderColumn,orderType);
    }
}
