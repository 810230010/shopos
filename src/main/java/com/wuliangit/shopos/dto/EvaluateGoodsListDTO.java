package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * @author boom
 * @description ${DESCRIPTION}
 * @create 2017-05-26 16:42
 **/
public class EvaluateGoodsListDTO {

    private Integer evaluateGoodsId;

    private String memberUsername;

    private Integer orderId;

    private Integer star;

    private String content;

    private Date createTime;

    private Boolean isShow;

    private String goodsName;

    private Boolean isAnonymous;

    public EvaluateGoodsListDTO() {
    }

    public EvaluateGoodsListDTO(Integer evaluateGoodsId, String memberUsername, Integer orderId, Integer star, String content, Date createTime, Boolean isShow, String goodsName, Boolean isAnonymous) {
        this.evaluateGoodsId = evaluateGoodsId;
        this.memberUsername = memberUsername;
        this.orderId = orderId;
        this.star = star;
        this.content = content;
        this.createTime = createTime;
        this.isShow = isShow;
        this.goodsName = goodsName;
        this.isAnonymous = isAnonymous;
    }

    public Integer getEvaluateGoodsId() {
        return evaluateGoodsId;
    }

    public void setEvaluateGoodsId(Integer evaluateGoodsId) {
        this.evaluateGoodsId = evaluateGoodsId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }
}
