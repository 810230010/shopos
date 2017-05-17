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

    private String shareCount;

    private String buyCount;

    public TuikePageListDTO(Integer tuikeId, String nickname, Date createTime, Long availableBalance, Long freezeBalance, String code, String shareCount, String buyCount) {
        this.tuikeId = tuikeId;
        this.nickname = nickname;
        this.createTime = createTime;
        this.availableBalance = availableBalance;
        this.freezeBalance = freezeBalance;
        this.code = code;
        this.shareCount = shareCount;
        this.buyCount = buyCount;
    }

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

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount;
    }

    public String getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(String buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getTuikeId() {
        return tuikeId;
    }

    public void setTuikeId(Integer tuikeId) {
        this.tuikeId = tuikeId;
    }
}
