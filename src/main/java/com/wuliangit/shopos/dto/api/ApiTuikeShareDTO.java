package com.wuliangit.shopos.dto.api;

import java.util.Date;

/**
 * Created by wuliang01 on 2017/7/5.
 */
public class ApiTuikeShareDTO {

    private Integer tuikeShareId;

    private Integer tuikeId;

    private Date shareTime;

    private Integer goodsId;

    private Integer click;

    public ApiTuikeShareDTO() {
    }

    public ApiTuikeShareDTO(Integer tuikeShareId, Integer tuikeId, Date shareTime, Integer goodsId, Integer click) {
        this.tuikeShareId = tuikeShareId;
        this.tuikeId = tuikeId;
        this.shareTime = shareTime;
        this.goodsId = goodsId;
        this.click = click;
    }

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
