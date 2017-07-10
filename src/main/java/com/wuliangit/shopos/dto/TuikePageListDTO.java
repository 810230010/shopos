package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by 26229 on 2017/4/28.
 */
public class TuikePageListDTO {

    private Integer tuikeId;

    private String nickname;

    private Date createTime;

    private Long availableBalance;

    private Long freezeBalance;

    private String code;

    private Integer shareCount;

    private Integer buyCount;


    public TuikePageListDTO() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(Long freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getTuikeId() {
        return tuikeId;
    }

    public void setTuikeId(Integer tuikeId) {
        this.tuikeId = tuikeId;
    }
}
