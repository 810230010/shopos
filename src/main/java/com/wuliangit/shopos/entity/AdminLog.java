package com.wuliangit.shopos.entity;

import java.util.Date;

public class AdminLog {
    private Integer adminLogId;

    private String content;

    private Date createTime;

    private String adminUsername;

    private Integer adminId;

    private String ip;

    public AdminLog(Integer adminLogId, String content, Date createTime, String adminUsername, Integer adminId, String ip) {
        this.adminLogId = adminLogId;
        this.content = content;
        this.createTime = createTime;
        this.adminUsername = adminUsername;
        this.adminId = adminId;
        this.ip = ip;
    }

    public AdminLog() {
        super();
    }

    public Integer getAdminLogId() {
        return adminLogId;
    }

    public void setAdminLogId(Integer adminLogId) {
        this.adminLogId = adminLogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername == null ? null : adminUsername.trim();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}