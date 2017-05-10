package com.wuliangit.shopos.model;

import com.wuliangit.shopos.entity.OrderGoods;

import java.util.List;

/**
 * Created by nilme on 2017/5/5.
 */
public class OrderGoodsNum {

    private Integer storeId;

    private List<OrderGoodsInfo> orderGoodsInfoList;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<OrderGoodsInfo> getOrderGoodsInfoList() {
        return orderGoodsInfoList;
    }

    public void setOrderGoodsInfoList(List<OrderGoodsInfo> orderGoodsInfoList) {
        this.orderGoodsInfoList = orderGoodsInfoList;
    }
}
