package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.Voucher;

public interface VoucherMapper {
    int deleteByPrimaryKey(Integer voucherId);

    int insert(Voucher record);

    int insertSelective(Voucher record);

    Voucher selectByPrimaryKey(Integer voucherId);

    int updateByPrimaryKeySelective(Voucher record);

    int updateByPrimaryKey(Voucher record);
}