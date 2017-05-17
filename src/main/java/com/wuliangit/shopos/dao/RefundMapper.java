package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiRefundDTO;
import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.entity.Refund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundMapper extends BaseMapper<Refund, Integer> {

    /**
     * @Description: 获取退换货申请列表的数据
     * @Author: pangweichao
     * @Date: 10:26 2017/5/12
     * @Param: [searchKey, orderColumn, orderType]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreRefundListDTO>
     */
    List<StoreRefundListDTO> getApplyRefundList(@Param("searchKey") String searchKey,@Param("orderColumn") String orderColumn,@Param("orderType") String orderType);

    /**
     * @Description: 审核退换货的申请
     * @Author: pangweichao
     * @Date: 10:54 2017/5/12
     * @Param: [refundId, sellerState]
     * @return: java.lang.Integer
     */
    Integer checkRefundApply(@Param("refundId") Integer refundId,@Param("sellerState") String sellerState);

    /**
     * @Description: 获取成功申请退换货的数据
     * @Author: pangweichao
     * @Date: 11:42 2017/5/12
     * @Param: [searchKey, orderColumn, orderType, type]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreRefundListDTO>
     */
    List<StoreRefundListDTO> getSuccessRefundList(@Param("searchKey") String searchKey,@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("type") String type);

    /**
     * 接口获取退款列表
     * @param memberId
     * @return
     */
    List<ApiRefundDTO> apiGetRefunds(Integer memberId);
}