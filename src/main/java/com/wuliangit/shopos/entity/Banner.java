package com.wuliangit.shopos.entity;

public class Banner {
    private Integer tBannerId;

    private String pictureUrl;

    private String externalUrl;

    private Boolean statusFlag;

    public Integer gettBannerId() {
        return tBannerId;
    }

    public void settBannerId(Integer tBannerId) {
        this.tBannerId = tBannerId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl == null ? null : externalUrl.trim();
    }

    public Boolean getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(Boolean statusFlag) {
        this.statusFlag = statusFlag;
    }
}