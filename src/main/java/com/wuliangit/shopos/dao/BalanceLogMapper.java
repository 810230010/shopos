package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.BalanceLog;

public interface BalanceLogMapper {
    int deleteByPrimaryKey(Integer balanceLogId);

    int insert(BalanceLog record);

    int insertSelective(BalanceLog record);

    BalanceLog selectByPrimaryKey(Integer balanceLogId);

    int updateByPrimaryKeySelective(BalanceLog record);

    int updateByPrimaryKey(BalanceLog record);
}