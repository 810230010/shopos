package com.wuliangit.shopos.dto.api;

/**
 * Created by nilme on 2017/6/7.
 */
public class ApiSellerInfo {

    private String type;

    private String name;

    private Integer storeId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
