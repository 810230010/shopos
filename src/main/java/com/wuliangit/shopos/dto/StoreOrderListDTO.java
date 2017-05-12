package com.wuliangit.shopos.dto;

import java.math.BigDecimal;

/**
 * @author pangweichao
 * @description 订单列表的数据
 * @create 2017-05-11 17:32
 **/
public class StoreOrderListDTO {

    private Integer orderId;

    private String outTradeNo;

    private String memberName;

    private String memberEmail;

    private BigDecimal orderAmount;

    private String orderState;

    private String carriageName;

    public StoreOrderListDTO() {
    }

    public StoreOrderListDTO(Integer orderId, String outTradeNo, String memberName, String memberEmail, BigDecimal orderAmount, String orderState, String carriageName) {
        this.orderId = orderId;
        this.outTradeNo = outTradeNo;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.orderAmount = orderAmount;
        this.orderState = orderState;
        this.carriageName = carriageName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getCarriageName() {
        return carriageName;
    }

    public void setCarriageName(String carriageName) {
        this.carriageName = carriageName;
    }
}
