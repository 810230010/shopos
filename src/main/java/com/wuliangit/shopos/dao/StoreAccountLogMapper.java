package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.StoreAccountLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreAccountLogMapper extends BaseMapper<StoreAccountLog, Integer> {

    /**
     * 店铺资金流水记录
     *
     * @param storeId
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<StoreAccountLog> getAccountHistoryList( @Param("storeId")Integer storeId, @Param("orderColumn") String orderColumn,
                                                @Param("orderType") String orderType);
}