package com.wuliangit.shopos.entity;

import java.util.Date;

public class MemberAdvice {
    private Integer memberAdviceId;

    private Integer memberId;

    private String memberName;

    private Byte status;

    private Date createTime;

    private String adviceContent;

    public Integer getMemberAdviceId() {
        return memberAdviceId;
    }

    public void setMemberAdviceId(Integer memberAdviceId) {
        this.memberAdviceId = memberAdviceId;
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
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }
}