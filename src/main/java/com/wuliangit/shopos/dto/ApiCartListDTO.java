package com.wuliangit.shopos.dto;

import com.wuliangit.shopos.entity.Cart;

import java.util.List;

/**
 * Created by nilme on 2017/5/11.
 */
public class ApiCartListDTO {

    private String storeName;
    private Integer storeId;
    private boolean checked;
    private List<ApiCartDTO> carts;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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

    public List<ApiCartDTO> getCarts() {
        return carts;
    }

    public void setCarts(List<ApiCartDTO> carts) {
        this.carts = carts;
    }
}
