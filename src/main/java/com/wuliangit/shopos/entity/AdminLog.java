package com.wuliangit.shopos.entity;

import java.util.Date;

public class AdminLog {
    private Integer adminLogId;

    private String content;

    private Date createtime;

    private String adminUsername;

    private Integer adminId;

    private String ip;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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