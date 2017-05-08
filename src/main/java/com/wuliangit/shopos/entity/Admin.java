package com.wuliangit.shopos.entity;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String username;

    private String password;

    private Date loginTime;

    private Integer loginNum;

    private String salt;

    private Date createTime;

    private Boolean delFlag;

    public Admin(Integer adminId, String username, String password, Date loginTime, Integer loginNum, String salt, Date createTime, Boolean delFlag) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.loginTime = loginTime;
        this.loginNum = loginNum;
        this.salt = salt;
        this.createTime = createTime;
        this.delFlag = delFlag;
    }

    public Admin() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}