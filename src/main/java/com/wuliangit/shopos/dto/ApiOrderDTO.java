package com.wuliangit.shopos.dto;

import com.wuliangit.shopos.entity.OrderGoods;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by nilme on 2017/5/17.
 */
public class ApiOrderDTO {

    private Integer orderId;

    private String outTradeNo;

    private String outTradeNoMerge;

    private String tradeNo;

    private Integer storeId;

    private String storeName;

    private Integer memberId;

    private String memberName;

    private String memberEmail;

    private String paymentCode;

    private Date paymentTime;

    private Date finishedTime;

    private BigDecimal goodsAmount;

    private BigDecimal orderAmount;

    private BigDecimal pdAmount;

    private BigDecimal carriageAmount;

    private String memberEvaluationState;

    private String sellerEvaluationState;

    private String orderState;

    private String refundState;

    private Boolean isLock;

    private String deleteState;

    private BigDecimal refundAmount;

    private String orderFrom;

    private String expressName;

    private String expressNo;

    private Date createTime;

    private Date deliverTime;

    private String orderMessage;

    private Integer orderPointscount;

    private Long voucherPrice;

    private String voucherCode;

    private String reciverAddress;

    private String reciverPhone;

    private String reciverName;

    private String invoiceInfo;

    private List<ApiOrderGoodsDTO> orderGoodses;


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

    public String getOutTradeNoMerge() {
        return outTradeNoMerge;
    }

    public void setOutTradeNoMerge(String outTradeNoMerge) {
        this.outTradeNoMerge = outTradeNoMerge;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPdAmount() {
        return pdAmount;
    }

    public void setPdAmount(BigDecimal pdAmount) {
        this.pdAmount = pdAmount;
    }

    public BigDecimal getCarriageAmount() {
        return carriageAmount;
    }

    public void setCarriageAmount(BigDecimal carriageAmount) {
        this.carriageAmount = carriageAmount;
    }

    public String getMemberEvaluationState() {
        return memberEvaluationState;
    }

    public void setMemberEvaluationState(String memberEvaluationState) {
        this.memberEvaluationState = memberEvaluationState;
    }

    public String getSellerEvaluationState() {
        return sellerEvaluationState;
    }

    public void setSellerEvaluationState(String sellerEvaluationState) {
        this.sellerEvaluationState = sellerEvaluationState;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public String getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(String deleteState) {
        this.deleteState = deleteState;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public Integer getOrderPointscount() {
        return orderPointscount;
    }

    public void setOrderPointscount(Integer orderPointscount) {
        this.orderPointscount = orderPointscount;
    }

    public Long getVoucherPrice() {
        return voucherPrice;
    }

    public void setVoucherPrice(Long voucherPrice) {
        this.voucherPrice = voucherPrice;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
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

    public String getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(String invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public List<ApiOrderGoodsDTO> getOrderGoodses() {
        return orderGoodses;
    }

    public void setOrderGoodses(List<ApiOrderGoodsDTO> orderGoodses) {
        this.orderGoodses = orderGoodses;
    }
}
