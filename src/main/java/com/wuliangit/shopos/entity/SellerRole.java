package com.wuliangit.shopos.entity;

public class SellerRole {
    private Integer sellerRoleId;

    private String office;

    private String name;

    private String role;

    private Boolean isDefault;

    private Boolean useable;

    private Integer createBy;

    private String permissionList;

    public Integer getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Integer sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getUseable() {
        return useable;
    }

    public void setUseable(Boolean useable) {
        this.useable = useable;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(String permissionList) {
        this.permissionList = permissionList == null ? null : permissionList.trim();
    }
}