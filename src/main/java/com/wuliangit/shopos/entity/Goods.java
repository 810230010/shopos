package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer goodsId;

    private String name;

    private String unit;

    private String adWord;

    private Integer storeId;

    private String storeName;

    private Integer goodsCategory1Id;

    private Integer goodsCategory2Id;

    private Integer goodsCategory3Id;

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

    private Boolean isVirtual;

    private Boolean virtualInvalidRefund;

    private Boolean isAppoint;

    private Boolean isPresell;

    private Boolean vat;

    private Boolean commend;

    private Integer evaluationGoodStar;

    private Integer evaluationCount;

    private Boolean delFlag;

    private String attrs;

    private Boolean isPlatform;

    private String area;

    private String checkMsg;

    private Date sellTimeBegin;

    private Date sellTimeEnd;

    private Integer needCount;

    private String uploadFrom;

    private Double gpsLng;

    private Double gpsLat;

    private Integer activityId;

    private Long activityPrice;

    private String activityJoinState;

    private String goodsBody;

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
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getAdWord() {
        return adWord;
    }

    public void setAdWord(String adWord) {
        this.adWord = adWord == null ? null : adWord.trim();
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
        this.promotionType = promotionType == null ? null : promotionType.trim();
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
        this.images = images == null ? null : images.trim();
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg == null ? null : titleImg.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify == null ? null : verify.trim();
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

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Boolean getVirtualInvalidRefund() {
        return virtualInvalidRefund;
    }

    public void setVirtualInvalidRefund(Boolean virtualInvalidRefund) {
        this.virtualInvalidRefund = virtualInvalidRefund;
    }

    public Boolean getIsAppoint() {
        return isAppoint;
    }

    public void setIsAppoint(Boolean isAppoint) {
        this.isAppoint = isAppoint;
    }

    public Boolean getIsPresell() {
        return isPresell;
    }

    public void setIsPresell(Boolean isPresell) {
        this.isPresell = isPresell;
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

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs == null ? null : attrs.trim();
    }

    public Boolean getIsPlatform() {
        return isPlatform;
    }

    public void setIsPlatform(Boolean isPlatform) {
        this.isPlatform = isPlatform;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCheckMsg() {
        return checkMsg;
    }

    public void setCheckMsg(String checkMsg) {
        this.checkMsg = checkMsg == null ? null : checkMsg.trim();
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

    public Integer getNeedCount() {
        return needCount;
    }

    public void setNeedCount(Integer needCount) {
        this.needCount = needCount;
    }

    public String getUploadFrom() {
        return uploadFrom;
    }

    public void setUploadFrom(String uploadFrom) {
        this.uploadFrom = uploadFrom == null ? null : uploadFrom.trim();
    }

    public Double getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(Double gpsLng) {
        this.gpsLng = gpsLng;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Long getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Long activityPrice) {
        this.activityPrice = activityPrice;
    }

    public String getActivityJoinState() {
        return activityJoinState;
    }

    public void setActivityJoinState(String activityJoinState) {
        this.activityJoinState = activityJoinState == null ? null : activityJoinState.trim();
    }

    public String getGoodsBody() {
        return goodsBody;
    }

    public void setGoodsBody(String goodsBody) {
        this.goodsBody = goodsBody == null ? null : goodsBody.trim();
    }
}