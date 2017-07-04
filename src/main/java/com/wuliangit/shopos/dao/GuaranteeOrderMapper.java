package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.GuaranteeOrder;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/4.
 */
public interface GuaranteeOrderMapper extends BaseMapper<GuaranteeOrder, Integer> {

    GuaranteeOrder selectGuaranteeOrderByOutTradeNo(@Param("outTradeNo") String outTradeNo);
}