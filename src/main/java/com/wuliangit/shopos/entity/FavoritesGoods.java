package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FavoritesGoods {
    private Integer favoritesGoodsId;

    private Integer memberId;

    private String memberName;

    private Date favTime;

    private Integer goodsId;

    private String goodsName;

    private BigDecimal logPrice;

    private String logMsg;

    public Integer getFavoritesGoodsId() {
        return favoritesGoodsId;
    }

    public void setFavoritesGoodsId(Integer favoritesGoodsId) {
        this.favoritesGoodsId = favoritesGoodsId;
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

    public Date getFavTime() {
        return favTime;
    }

    public void setFavTime(Date favTime) {
        this.favTime = favTime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getLogPrice() {
        return logPrice;
    }

    public void setLogPrice(BigDecimal logPrice) {
        this.logPrice = logPrice;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg == null ? null : logMsg.trim();
    }
}