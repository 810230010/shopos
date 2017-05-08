package com.wuliangit.shopos.entity;

import java.util.Date;

public class Address {
    private Integer addressId;

    private Integer memberId;

    private String reciverName;

    private String provinceId;

    private Integer cityId;

    private Integer areaId;

    private String areaInfo;

    private String address;

    private String telPhone;

    private String mobPhone;

    private Boolean isDefault;

    private Date createTime;

    public Address(Integer addressId, Integer memberId, String reciverName, String provinceId, Integer cityId, Integer areaId, String areaInfo, String address, String telPhone, String mobPhone, Boolean isDefault, Date createTime) {
        this.addressId = addressId;
        this.memberId = memberId;
        this.reciverName = reciverName;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.areaInfo = areaInfo;
        this.address = address;
        this.telPhone = telPhone;
        this.mobPhone = mobPhone;
        this.isDefault = isDefault;
        this.createTime = createTime;
    }

    public Address() {
        super();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName == null ? null : reciverName.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo == null ? null : areaInfo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone == null ? null : mobPhone.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}