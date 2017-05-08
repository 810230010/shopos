package com.wuliangit.shopos.entity;

import java.util.Date;

public class FavoritesStore {
    private Integer favoritesStoreId;

    private Integer memberId;

    private String memberName;

    private Date favTime;

    private Integer storeId;

    private String storeName;

    private String logMsg;

    public FavoritesStore(Integer favoritesStoreId, Integer memberId, String memberName, Date favTime, Integer storeId, String storeName, String logMsg) {
        this.favoritesStoreId = favoritesStoreId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.favTime = favTime;
        this.storeId = storeId;
        this.storeName = storeName;
        this.logMsg = logMsg;
    }

    public FavoritesStore() {
        super();
    }

    public Integer getFavoritesStoreId() {
        return favoritesStoreId;
    }

    public void setFavoritesStoreId(Integer favoritesStoreId) {
        this.favoritesStoreId = favoritesStoreId;
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg == null ? null : logMsg.trim();
    }
}