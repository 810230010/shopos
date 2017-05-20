package com.wuliangit.shopos.dto;

import java.util.List;

/**
 * Created by nilme on 2017/5/20.
 */
public class StoreMessageDTO {

    List<Integer> receiveUserIds;
    private String title;
    private String content;
    private String templates;

    public List<Integer> getReceiveUserIds() {
        return receiveUserIds;
    }

    public void setReceiveUserIds(List<Integer> receiveUserIds) {
        this.receiveUserIds = receiveUserIds;
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

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates;
    }
}
