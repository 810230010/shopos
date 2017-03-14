package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.StoreGrade;

public interface StoreGradeMapper {
    int deleteByPrimaryKey(Integer storeGradeId);

    int insert(StoreGrade record);

    int insertSelective(StoreGrade record);

    StoreGrade selectByPrimaryKey(Integer storeGradeId);

    int updateByPrimaryKeySelective(StoreGrade record);

    int updateByPrimaryKeyWithBLOBs(StoreGrade record);

    int updateByPrimaryKey(StoreGrade record);
}