package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.BalanceCash;

public interface BalanceCashMapper {
    int deleteByPrimaryKey(Integer balanceCashId);

    int insert(BalanceCash record);

    int insertSelective(BalanceCash record);

    BalanceCash selectByPrimaryKey(Integer balanceCashId);

    int updateByPrimaryKeySelective(BalanceCash record);

    int updateByPrimaryKey(BalanceCash record);
}