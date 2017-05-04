package com.wuliangit.shopos.model;

/**
 * Created by JangJanPing on 2017/5/1.
 */
public class StoreBrand {
    private Integer id;
    private Integer brandId;
    private String brandName;
    private String pic;
    private String categoryName;
    private String passed;
    private String isOnshelf;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    public String getIsOnshelf() {
        return isOnshelf;
    }

    public void setIsOnshelf(String isOnshelf) {
        this.isOnshelf = isOnshelf;
    }

    @Override
    public String toString() {
        return "StoreBrand{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", pic='" + pic + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", passed='" + passed + '\'' +
                ", isOnshelf='" + isOnshelf + '\'' +
                '}';
    }
}
