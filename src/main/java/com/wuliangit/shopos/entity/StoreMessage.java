package com.wuliangit.shopos.entity;

public class StoreMessage {
    private Integer storeMessageId;

    private Integer sendUser;

    private String sendUserName;

    private String createTime;

    private Integer receiveUser;

    private String receiveUserName;

    private Byte readFlag;

    private Byte delFlag;

    private String title;

    private String content;

    public Integer getStoreMessageId() {
        return storeMessageId;
    }

    public void setStoreMessageId(Integer storeMessageId) {
        this.storeMessageId = storeMessageId;
    }

    public Integer getSendUser() {
        return sendUser;
    }

    public void setSendUser(Integer sendUser) {
        this.sendUser = sendUser;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName == null ? null : sendUserName.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(Integer receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName == null ? null : receiveUserName.trim();
    }

    public Byte getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Byte readFlag) {
        this.readFlag = readFlag;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}