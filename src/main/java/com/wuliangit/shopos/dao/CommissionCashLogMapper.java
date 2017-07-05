package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.CommissionCashLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/4.
 */
public interface CommissionCashLogMapper extends BaseMapper<CommissionCashLog , Integer> {
    /**
     * 获取推客佣金提现记录
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<CommissionCashLog> getCommissionLogList(@Param("searchKey") String searchKey,
                                                 @Param("orderColumn") String orderColumn,
                                                 @Param("orderType") String orderType);
}
