package com.wuliangit.shopos.dto;

import com.wuliangit.shopos.model.OrderGoodsInfo;

import java.util.List;

/**
 * Created by nilme on 2017/5/10.
 */
public class ApiOrderCreateDTO {

    private List<OrderGoodsInfo> orderGoodsInfoList;
    private Integer addressId;
    private String orderFrom;
    private String orderMessage;

    public List<OrderGoodsInfo> getOrderGoodsInfoList() {
        return orderGoodsInfoList;
    }

    public void setOrderGoodsInfoList(List<OrderGoodsInfo> orderGoodsInfoList) {
        this.orderGoodsInfoList = orderGoodsInfoList;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }
}
