package com.wuliangit.shopos.dto;

/**
 * @author boom
 * @description banner整个实体类
 * @create 2017-06-02 15:08
 **/
public class BannerDTO {
    private Integer tBannerId;

    private String pictureUrl;

    private String externalUrl;

    private Boolean statusFlag;

    public BannerDTO() {
    }

    public BannerDTO(Integer tBannerId, String pictureUrl, String externalUrl, Boolean statusFlag) {
        this.tBannerId = tBannerId;
        this.pictureUrl = pictureUrl;
        this.externalUrl = externalUrl;
        this.statusFlag = statusFlag;
    }

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
