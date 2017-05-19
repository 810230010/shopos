package com.wuliangit.shopos.dto;

/**
 * Created by JangJanPing on 2017/5/18.
 */
public class AdminRoleDTO {
    private Integer adminRoleId;
    private String name;
    private Integer defaultRole;

    public Integer getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Integer defaultRole) {
        this.defaultRole = defaultRole;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
