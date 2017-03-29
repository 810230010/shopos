package com.wuliangit.shopos.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nilme on 2017/3/29.
 */
public class CollectGoodsDTO {

    private Integer favoritesGoodId;

    private Integer memberId;

    private String titleImg;

    private Date favTime;

    private Integer goodsId;

    private String goodsName;

    private BigDecimal logPrice;

    private BigDecimal price;

    private String logMsg;

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getFavoritesGoodId() {
        return favoritesGoodId;
    }

    public void setFavoritesGoodId(Integer favoritesGoodId) {
        this.favoritesGoodId = favoritesGoodId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getFavTime() {
        return favTime;
    }

    public void setFavTime(Date favTime) {
        this.favTime = favTime;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getLogPrice() {
        return logPrice;
    }

    public void setLogPrice(BigDecimal logPrice) {
        this.logPrice = logPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }
}
