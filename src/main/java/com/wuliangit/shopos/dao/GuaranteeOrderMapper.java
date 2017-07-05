package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.GuaranteeOrder;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/4.
 */
public interface GuaranteeOrderMapper extends BaseMapper<GuaranteeOrder, Integer> {
    /**
     * 根据订单编号得到保证金订单
     * @param outTradeNo
     * @return
     */
    GuaranteeOrder selectGuaranteeOrderByOutTradeNo(@Param("outTradeNo") String outTradeNo);

    /**
     * 根据店铺名修改店铺缴纳保证金状态
     * @param storeId
     * @return
     */
    int updataStoreGuaranteePayedStatus(@Param("storeId") Integer storeId);

    String getGuaranteePayedStatus(Integer storeId);
}