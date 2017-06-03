package com.wuliangit.shopos.dto;

/**
 * @author boom
 * @description 用于admin选择需要发送的DTO
 * @create 2017-06-03 11:44
 **/
public class AdminMailToSelectDTO {

    private Integer storeId;

    private String name;

    private String email;

    public AdminMailToSelectDTO() {
    }

    public AdminMailToSelectDTO(Integer storeId, String name, String email) {
        this.storeId = storeId;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
