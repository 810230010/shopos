package com.wuliangit.shopos.model;

import java.util.List;

/**
 * Created by nilme on 2017/5/5.
 */
public class OrderGoodsNum1 {

    private Integer storeId;

    private List<OrderGoodsNum> orderGoodsNumList;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<OrderGoodsNum> getOrderGoodsNumList() {
        return orderGoodsNumList;
    }

    public void setOrderGoodsNumList(List<OrderGoodsNum> orderGoodsNumList) {
        this.orderGoodsNumList = orderGoodsNumList;
    }
}
