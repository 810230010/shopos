package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by 26229 on 2017/5/5.
 */
public class StorePageListDTO {

    private Integer storeId;

    private String name;

    private String state;

    private Date createTime;

    private String sellerNikename;

    private String type;

    public StorePageListDTO() {
    }

    public StorePageListDTO(Integer storeId, String name, String state, Date createTime, String sellerNikename, String type) {
        this.storeId = storeId;
        this.name = name;
        this.state = state;
        this.createTime = createTime;
        this.sellerNikename = sellerNikename;
        this.type = type;
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

    public String getSellerNikename() {
        return sellerNikename;
    }

    public void setSellerNikename(String sellerNikename) {
        this.sellerNikename = sellerNikename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
