package com.wuliangit.shopos.common.dao;


import java.io.Serializable;

public interface BaseMapper<T, ID extends Serializable> {

    T selectByPrimaryKey(ID id);

    int deleteByPrimaryKey(ID id);

    int insert(T entity);

    int insertSelective(T entity);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);

}