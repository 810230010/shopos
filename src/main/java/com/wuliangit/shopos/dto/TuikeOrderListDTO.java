package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by wuliang01 on 2017/7/5.
 */
public class TuikeOrderListDTO {

    private Integer orderCommissionId;

    private String outTradeNo;

    private Short commission;

    private String tuikeCode;

    private Integer memberId;

    private Date creatTime;

    private String memberName;

    public TuikeOrderListDTO() {
    }

    public TuikeOrderListDTO(Integer orderCommissionId, String outTradeNo, Short commission, String tuikeCode, Integer memberId, Date creatTime, String memberName) {
        this.orderCommissionId = orderCommissionId;
        this.outTradeNo = outTradeNo;
        this.commission = commission;
        this.tuikeCode = tuikeCode;
        this.memberId = memberId;
        this.creatTime = creatTime;
        this.memberName = memberName;
    }

    public Integer getOrderCommissionId() {
        return orderCommissionId;
    }

    public void setOrderCommissionId(Integer orderCommissionId) {
        this.orderCommissionId = orderCommissionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Short getCommission() {
        return commission;
    }

    public void setCommission(Short commission) {
        this.commission = commission;
    }

    public String getTuikeCode() {
        return tuikeCode;
    }

    public void setTuikeCode(String tuikeCode) {
        this.tuikeCode = tuikeCode;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
