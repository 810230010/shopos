package com.wuliangit.shopos.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author boom
 * @description 商家佣金管理页面DTO
 * @create 2017-06-02 10:02
 **/
public class StoreCashListDTO {

    private Integer storeId;

    private BigDecimal amount;

    private Date createTime;

    private String outBizNo;

    private String name;

    public StoreCashListDTO() {
    }

    /**
     * @Description: all
     * @Author: pangweichao
     * @Date: 10:04 2017/6/2
     * @Param: [storeId, amount, createTime, outBizNo, name]
     * @return:
     */
    public StoreCashListDTO(Integer storeId, BigDecimal amount, Date createTime, String outBizNo, String name) {
        this.storeId = storeId;
        this.amount = amount;
        this.createTime = createTime;
        this.outBizNo = outBizNo;
        this.name = name;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
