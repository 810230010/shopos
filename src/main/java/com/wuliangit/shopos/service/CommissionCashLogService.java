package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.TuikeOrderListDTO;
import com.wuliangit.shopos.entity.CommissionCashLog;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/4.
 */
public interface CommissionCashLogService {
    /**
     * 获取推客佣金提现记录
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    List<CommissionCashLog> getCommissionLogList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize);
}
