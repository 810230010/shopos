package com.wuliangit.shopos.dto;

import java.util.List;

/**
 * Created by nilme on 2017/5/12.
 */
public class MenuDTO {

    private Integer permissionId;

    private Integer parentId;

    private String name;

    private String href;

    private String icon;

    private String permission;

    private List<MenuDTO> childMenus;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<MenuDTO> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuDTO> childMenus) {
        this.childMenus = childMenus;
    }
}
