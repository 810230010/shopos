package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.RefundReturn;

public interface RefundReturnMapper {
    int deleteByPrimaryKey(Integer refundId);

    int insert(RefundReturn record);

    int insertSelective(RefundReturn record);

    RefundReturn selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(RefundReturn record);

    int updateByPrimaryKey(RefundReturn record);
}