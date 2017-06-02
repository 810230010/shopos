package com.wuliangit.shopos.dto;

import java.math.BigDecimal;

/**
 * @author boom
 * @description 商家账户管理列表DTO
 * @create 2017-06-02 9:59
 **/
public class StoreAccountListDTO {

    private Integer storeId;

    private BigDecimal availableBalance;

    private BigDecimal freezeBalance;

    private String alipayAccount;

    private String name;

    public StoreAccountListDTO() {
    }

    /**
     * @Description: all
     * @Author: pangweichao
     * @Date: 10:01 2017/6/2
     * @Param: [storeId, availableBalance, freezeBalance, alipayAccount, name]
     * @return:
     */
    public StoreAccountListDTO(Integer storeId, BigDecimal availableBalance, BigDecimal freezeBalance, String alipayAccount, String name) {
        this.storeId = storeId;
        this.availableBalance = availableBalance;
        this.freezeBalance = freezeBalance;
        this.alipayAccount = alipayAccount;
        this.name = name;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
