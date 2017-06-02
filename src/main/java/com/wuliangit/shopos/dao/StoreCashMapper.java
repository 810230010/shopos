package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.StoreCashListDTO;
import com.wuliangit.shopos.entity.StoreCash;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreCashMapper extends BaseMapper<StoreCash, Integer> {

    /**
     * 提现记录
     * @param storeId
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<StoreCash> getCashHistoryList(@Param("storeId") Integer storeId,
                                       @Param("orderColumn") String orderColumn,
                                       @Param("orderType")String orderType);

    /**
     * @Description: 获取订单佣金管理
     * @Author: pangweichao
     * @Date: 10:16 2017/6/2
     * @Param: [orderColumn, orderType, searchKey]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreCashListDTO>
     */
    List<StoreCashListDTO> getCashListDate(@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("searchKey") String searchKey);
}