package com.wuliangit.shopos.entity;

public class SellerPermission {
    private Integer sellerPermissionId;

    private Integer parentId;

    private String name;

    private Integer sort;

    private String href;

    private String icon;

    private String permission;

    private String type;

    private Boolean useable;

    public Integer getSellerPermissionId() {
        return sellerPermissionId;
    }

    public void setSellerPermissionId(Integer sellerPermissionId) {
        this.sellerPermissionId = sellerPermissionId;
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getUseable() {
        return useable;
    }

    public void setUseable(Boolean useable) {
        this.useable = useable;
    }
}