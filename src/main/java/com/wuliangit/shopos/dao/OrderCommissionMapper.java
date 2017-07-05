package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.TuikeOrderListDTO;
import com.wuliangit.shopos.entity.OrderCommission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/5.
 */
public interface OrderCommissionMapper extends BaseMapper<OrderCommission, Integer> {
    /**
     * 推客推广订单列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<TuikeOrderListDTO> getTuikeOrderList(@Param("searchKey") String searchKey,
                                              @Param("orderColumn") String orderColumn,
                                              @Param("orderType") String orderType);
}
