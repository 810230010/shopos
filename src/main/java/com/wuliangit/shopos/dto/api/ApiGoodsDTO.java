package com.wuliangit.shopos.dto.api;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nilme on 2017/6/6.
 */
public class ApiGoodsDTO {

    private Integer goodsId;

    private String name;

    private String unit;

    private String adWord;

    private Integer storeId;

    private String storeName;

    private String storeLogo;

    private Integer goodsCategory1Id;

    private Integer goodsCategory2Id;

    private Integer goodsCategory3Id;

    private String goodsCategory1;

    private String goodsCategory2;

    private String goodsCategory3;

    private Integer brandId;

    private BigDecimal price;

    private BigDecimal carriage;

    private BigDecimal commission;

    private BigDecimal promotionPrice;

    private String promotionType;

    private BigDecimal marketprice;

    private Integer storageAlarm;

    private Integer click;

    private Integer salenum;

    private Integer collect;

    private Integer storage;

    private String images;

    private String titleImg;

    private String state;

    private String verify;

    private Date createTime;

    private Date editTime;

    private Boolean isNew;

    private String type;

    private Integer activityId;

    private String activityType;

    private Boolean isVirtual;

    private Boolean virtualInvalidRefund;

    private Boolean isAppoint;

    private Boolean isPresell;

    private Boolean vat;

    private Boolean commend;

    private Integer evaluationGoodStar;

    private Integer evaluationCount;

    private String attrs;

    private Boolean isPlatform;

    private String area;

    private Date sellTimeBegin;

    private Date sellTimeEnd;

    private String goodsBody;

    private Integer needCount;

    private Integer orderCount;


    public String getGoodsCategory1() {
        return goodsCategory1;
    }

    public void setGoodsCategory1(String goodsCategory1) {
        this.goodsCategory1 = goodsCategory1;
    }

    public String getGoodsCategory2() {
        return goodsCategory2;
    }

    public void setGoodsCategory2(String goodsCategory2) {
        this.goodsCategory2 = goodsCategory2;
    }

    public String getGoodsCategory3() {
        return goodsCategory3;
    }

    public void setGoodsCategory3(String goodsCategory3) {
        this.goodsCategory3 = goodsCategory3;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getNeedCount() {
        return needCount;
    }

    public void setNeedCount(Integer needCount) {
        this.needCount = needCount;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAdWord() {
        return adWord;
    }

    public void setAdWord(String adWord) {
        this.adWord = adWord;
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
        this.storeName = storeName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public Integer getGoodsCategory1Id() {
        return goodsCategory1Id;
    }

    public void setGoodsCategory1Id(Integer goodsCategory1Id) {
        this.goodsCategory1Id = goodsCategory1Id;
    }

    public Integer getGoodsCategory2Id() {
        return goodsCategory2Id;
    }

    public void setGoodsCategory2Id(Integer goodsCategory2Id) {
        this.goodsCategory2Id = goodsCategory2Id;
    }

    public Integer getGoodsCategory3Id() {
        return goodsCategory3Id;
    }

    public void setGoodsCategory3Id(Integer goodsCategory3Id) {
        this.goodsCategory3Id = goodsCategory3Id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCarriage() {
        return carriage;
    }

    public void setCarriage(BigDecimal carriage) {
        this.carriage = carriage;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public Integer getStorageAlarm() {
        return storageAlarm;
    }

    public void setStorageAlarm(Integer storageAlarm) {
        this.storageAlarm = storageAlarm;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Boolean getVirtual() {
        return isVirtual;
    }

    public void setVirtual(Boolean virtual) {
        isVirtual = virtual;
    }

    public Boolean getVirtualInvalidRefund() {
        return virtualInvalidRefund;
    }

    public void setVirtualInvalidRefund(Boolean virtualInvalidRefund) {
        this.virtualInvalidRefund = virtualInvalidRefund;
    }

    public Boolean getAppoint() {
        return isAppoint;
    }

    public void setAppoint(Boolean appoint) {
        isAppoint = appoint;
    }

    public Boolean getPresell() {
        return isPresell;
    }

    public void setPresell(Boolean presell) {
        isPresell = presell;
    }

    public Boolean getVat() {
        return vat;
    }

    public void setVat(Boolean vat) {
        this.vat = vat;
    }

    public Boolean getCommend() {
        return commend;
    }

    public void setCommend(Boolean commend) {
        this.commend = commend;
    }

    public Integer getEvaluationGoodStar() {
        return evaluationGoodStar;
    }

    public void setEvaluationGoodStar(Integer evaluationGoodStar) {
        this.evaluationGoodStar = evaluationGoodStar;
    }

    public Integer getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(Integer evaluationCount) {
        this.evaluationCount = evaluationCount;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    public Boolean getPlatform() {
        return isPlatform;
    }

    public void setPlatform(Boolean platform) {
        isPlatform = platform;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getSellTimeBegin() {
        return sellTimeBegin;
    }

    public void setSellTimeBegin(Date sellTimeBegin) {
        this.sellTimeBegin = sellTimeBegin;
    }

    public Date getSellTimeEnd() {
        return sellTimeEnd;
    }

    public void setSellTimeEnd(Date sellTimeEnd) {
        this.sellTimeEnd = sellTimeEnd;
    }

    public String getGoodsBody() {
        return goodsBody;
    }

    public void setGoodsBody(String goodsBody) {
        this.goodsBody = goodsBody;
    }
}
