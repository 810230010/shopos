package com.wuliangit.shopos.dto.api;

/**
 * Created by nilme on 2017/6/30.
 */
public class ApiStoreJoininDTO {

    private String type;   //类型：ENTERPRISE企业，STORE普通商家

    private String storeName; //店铺名

    private String contactsName;   //联系人姓名

    private String contactsPhone;   //联系人电话

    private String scIds;   //店铺入驻一级分类编号列表,用户英文逗号分割

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getScIds() {
        return scIds;
    }

    public void setScIds(String scIds) {
        this.scIds = scIds;
    }
}
