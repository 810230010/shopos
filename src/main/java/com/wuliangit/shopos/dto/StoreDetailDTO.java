package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by 26229 on 2017/5/5.
 */
public class StoreDetailDTO {

    private String name;

    private Integer gradeId;

    private Integer memberId;

    private String type;

    private String storeCompanyName;

    private String address;

    private String state;

    private Date createTime;

    private String banner;

    private String phone;

    private Integer credit;

    private String liveStoreName;

    private String liveStoreAddress;

    private Integer payGuaranteeMoney;

    public Integer getPayGuaranteeMoney() {
        return payGuaranteeMoney;
    }

    public void setPayGuaranteeMoney(Integer payGuaranteeMoney) {
        this.payGuaranteeMoney = payGuaranteeMoney;
    }

    public StoreDetailDTO() {
    }

    public StoreDetailDTO(String name, Integer gradeId, Integer memberId, String type, String storeCompanyName, String address, String state, Date createTime, String banner, String phone, Integer credit, String liveStoreName, String liveStoreAddress) {
        this.name = name;
        this.gradeId = gradeId;
        this.memberId = memberId;
        this.type = type;
        this.storeCompanyName = storeCompanyName;
        this.address = address;
        this.state = state;
        this.createTime = createTime;
        this.banner = banner;
        this.phone = phone;
        this.credit = credit;
        this.liveStoreName = liveStoreName;
        this.liveStoreAddress = liveStoreAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStoreCompanyName() {
        return storeCompanyName;
    }

    public void setStoreCompanyName(String storeCompanyName) {
        this.storeCompanyName = storeCompanyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getLiveStoreName() {
        return liveStoreName;
    }

    public void setLiveStoreName(String liveStoreName) {
        this.liveStoreName = liveStoreName;
    }

    public String getLiveStoreAddress() {
        return liveStoreAddress;
    }

    public void setLiveStoreAddress(String liveStoreAddress) {
        this.liveStoreAddress = liveStoreAddress;
    }
}
