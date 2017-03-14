package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.entity.OrderGoods;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer recId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer recId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}