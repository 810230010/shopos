package com.wuliangit.shopos.dto.api;

import com.wuliangit.shopos.entity.StoreGoodsAd;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nilme on 2017/5/16.
 */
public class ApiStoreDTO {
    private Integer storeId;

    private String name;

    private String type;

    private Integer provinceId;

    private String province;

    private String banner;

    private String logo;

    private Integer sales;

    private Integer collectCount;

    private Integer goodsCount;

    private Boolean sevenDayReturn;

    private Integer grade;

    private BigDecimal desccredit;

    private List<StoreGoodsAd> goodsAds;

    public Boolean getSevenDayReturn() {
        return sevenDayReturn;
    }

    public void setSevenDayReturn(Boolean sevenDayReturn) {
        this.sevenDayReturn = sevenDayReturn;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public List<StoreGoodsAd> getGoodsAds() {
        return goodsAds;
    }

    public void setGoodsAds(List<StoreGoodsAd> goodsAds) {
        this.goodsAds = goodsAds;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public BigDecimal getDesccredit() {
        return desccredit;
    }

    public void setDesccredit(BigDecimal desccredit) {
        this.desccredit = desccredit;
    }
}
