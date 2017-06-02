package com.wuliangit.shopos.dto;

import java.util.List;

/**
 * Created by nilme on 2017/5/20.
 */
public class StoreMessageDTO {

    List<String> receiveUserIds;
    List<String> receiveUsername;
    List<String> receiveMail;
    private String title;
    private String content;
    private String templates;

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

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates;
    }

    public List<String> getReceiveUsername() {
        return receiveUsername;
    }

    public void setReceiveUsername(List<String> receiveUsername) {
        this.receiveUsername = receiveUsername;
    }

    public List<String> getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(List<String> receiveMail) {
        this.receiveMail = receiveMail;
    }

    public List<String> getReceiveUserIds() {
        return receiveUserIds;
    }

    public void setReceiveUserIds(List<String> receiveUserIds) {
        this.receiveUserIds = receiveUserIds;
    }
}
