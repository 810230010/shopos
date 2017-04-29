package com.wuliangit.shopos.model;

/**
 * Created by nilme on 2017/4/20.
 */
public class StoreUser {

    private Integer storeId;

    private Integer memberId;

    private String username;

    private String nikename;

    private String photo;

    private String name;

    private String logo;

    private String sellerNikename;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSellerNikename() {
        return sellerNikename;
    }

    public void setSellerNikename(String sellerNikename) {
        this.sellerNikename = sellerNikename;
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
}
