package com.wuliangit.shopos.dto;

/**
 * @author pangweichao
 * @description 退换货列表数据
 * @create 2017-05-12 9:41
 **/
public class StoreRefundListDTO {

    private Integer refundId;

    private String orderSn;

    private String refundSn;

    private String memberName;

    private String goodsName;

    private String buyerMessage;

    private String refundType;

    public StoreRefundListDTO() {
    }

    public StoreRefundListDTO(Integer refundId, String orderSn, String refundSn, String memberName, String goodsName, String buyerMessage, String refundType) {
        this.refundId = refundId;
        this.orderSn = orderSn;
        this.refundSn = refundSn;
        this.memberName = memberName;
        this.goodsName = goodsName;
        this.buyerMessage = buyerMessage;
        this.refundType = refundType;
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }
}
