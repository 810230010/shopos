package com.wuliangit.shopos.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pangweichao
 * @description 订单列表的数据
 * @create 2017-05-11 17:32
 **/
public class StoreOrderListDTO {

    private Integer orderId;

    private Date createTime;

    private String outTradeNo;

    private String memberName;

    private String memberEmail;

    private String paymentCode;

    private BigDecimal orderAmount;

    private BigDecimal goodsAmount;

    private BigDecimal carriageAmount;

    private String orderState;

    private String carriageName;

    private String reciverAddress;

    private String reciverPhone;

    private String reciverName;

    private String orderFrom;

    private Boolean isLock;

    public BigDecimal getCarriageAmount() {
        return carriageAmount;
    }

    public void setCarriageAmount(BigDecimal carriageAmount) {
        this.carriageAmount = carriageAmount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getReciverAddress() {
        return reciverAddress;
    }

    public void setReciverAddress(String reciverAddress) {
        this.reciverAddress = reciverAddress;
    }

    public String getReciverPhone() {
        return reciverPhone;
    }

    public void setReciverPhone(String reciverPhone) {
        this.reciverPhone = reciverPhone;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

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
