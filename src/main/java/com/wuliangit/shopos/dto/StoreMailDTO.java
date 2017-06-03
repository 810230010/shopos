package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * @author boom
 * @description store的消息DTO
 * @create 2017-06-03 13:14
 **/
public class StoreMailDTO {

    private Integer storeMessageId;

    private Date createTime;

    private String sendUserName;

    private Boolean readFlag;

    private String title;

    private String content;

    public StoreMailDTO() {
    }

    public StoreMailDTO(Integer storeMessageId, Date createTime, String sendUserName, Boolean readFlag, String title, String content) {
        this.storeMessageId = storeMessageId;
        this.createTime = createTime;
        this.sendUserName = sendUserName;
        this.readFlag = readFlag;
        this.title = title;
        this.content = content;
    }

    public Integer getStoreMessageId() {
        return storeMessageId;
    }

    public void setStoreMessageId(Integer storeMessageId) {
        this.storeMessageId = storeMessageId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
