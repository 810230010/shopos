package com.wuliangit.shopos.dto;

/**
 * Created by nilme on 2017/4/28.
 */
public class StoreUpdateDTO {

    private Integer storeId;

    private String label;

    private String banner;

    private String logo;

    private String areaInfo;

    private String keywords;

    private String description;

    private String qq;

    private String ww;

    private String phone;

    private String presales;

    private String aftersales;

    private String liveStoreAddress;

    private Double liveStoreGpsLng;

    private Double liveStoreGpsLat;

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPresales() {
        return presales;
    }

    public void setPresales(String presales) {
        this.presales = presales;
    }

    public String getAftersales() {
        return aftersales;
    }

    public void setAftersales(String aftersales) {
        this.aftersales = aftersales;
    }

    public String getLiveStoreAddress() {
        return liveStoreAddress;
    }

    public void setLiveStoreAddress(String liveStoreAddress) {
        this.liveStoreAddress = liveStoreAddress;
    }

    public Double getLiveStoreGpsLng() {
        return liveStoreGpsLng;
    }

    public void setLiveStoreGpsLng(Double liveStoreGpsLng) {
        this.liveStoreGpsLng = liveStoreGpsLng;
    }

    public Double getLiveStoreGpsLat() {
        return liveStoreGpsLat;
    }

    public void setLiveStoreGpsLat(Double liveStoreGpsLat) {
        this.liveStoreGpsLat = liveStoreGpsLat;
    }
}
