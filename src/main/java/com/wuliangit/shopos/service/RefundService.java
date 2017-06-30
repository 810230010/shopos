package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.api.ApiRefundDTO;
import com.wuliangit.shopos.dto.StoreRefundListDTO;

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

    /**
     * @Description: 获取退换货列表的数据
     * @Author: pangweichao
     * @Date: 10:26 2017/5/12
     * @Param: [searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreRefundListDTO>
     */
    List<StoreRefundListDTO> getAdminRefundList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize);
}
