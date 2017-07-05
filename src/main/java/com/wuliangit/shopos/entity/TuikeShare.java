package com.wuliangit.shopos.entity;

import java.util.Date;

public class TuikeShare {
    private Integer tuikeShareId;

    private Integer tuikeId;

    private Date shareTime;

    private Integer goodsId;

    private Integer click;

    public Integer getTuikeShareId() {
        return tuikeShareId;
    }

    public void setTuikeShareId(Integer tuikeShareId) {
        this.tuikeShareId = tuikeShareId;
    }

    public Integer getTuikeId() {
        return tuikeId;
    }

    public void setTuikeId(Integer tuikeId) {
        this.tuikeId = tuikeId;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
}