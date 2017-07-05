package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.TuikeOrderListDTO;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/5.
 */
public interface OrderCommissionService {

    /**
     * 推客推广订单列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    List<TuikeOrderListDTO> getTuikeOrderList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize);
}
