package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.OrderCommon;

public interface OrderCommonMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderCommon record);

    int insertSelective(OrderCommon record);

    OrderCommon selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderCommon record);

    int updateByPrimaryKeyWithBLOBs(OrderCommon record);

    int updateByPrimaryKey(OrderCommon record);
}