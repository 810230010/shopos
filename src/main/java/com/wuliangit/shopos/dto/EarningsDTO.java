package com.wuliangit.shopos.dto;

import java.math.BigDecimal;

/**
 * Created by nilme on 2017/3/27.
 */
public class EarningsDTO {

    private BigDecimal availableBalance;

    private BigDecimal freezeBalance;


    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }
}
