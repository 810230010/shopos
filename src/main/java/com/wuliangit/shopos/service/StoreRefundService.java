package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.exception.BaseException;

import java.util.List;

/**
 * @author pangweichao
 * @description 退换货业务层
 * @create 2017-05-12 10:23
 **/
public interface StoreRefundService {

    /**
     * @Description: 获取退换货申请列表的数据
     * @Author: pangweichao
     * @Date: 10:26 2017/5/12
     * @Param: [searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreRefundListDTO>
     */
    List<StoreRefundListDTO> getApplyRefundList(String searchKey,String orderColumn,String orderType,Integer page,Integer pageSize);

    /**
     * @Description: 审核退换货的申请
     * @Author: pangweichao
     * @Date: 10:54 2017/5/12
     * @Param: [refundId, sellerState]
     * @return: java.lang.Integer
     */
    Integer checkRefundApply(Integer refundId,String sellerState) throws BaseException;

}
