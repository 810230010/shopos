package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiRefundDTO;

import java.util.List;

/**
 * Created by nilme on 2017/5/17.
 */
public interface RefundService {

    /**
     * api获取退款订单
     * @param page
     * @param pageSize
     * @return
     */
    List<ApiRefundDTO> apiGetRefundOrders(Integer page, Integer pageSize);
}
