package com.wuliangit.shopos.dto;

import java.util.List;

/**
 * Created by JangJanPing on 2017/5/18.
 */
public class AdminRoleDTO {
    private Integer adminRoleId;
    private String name;
    private Integer defaultRole;
    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private List<MenuDTO> rolePermissions;

    public List<MenuDTO> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<MenuDTO> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

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
