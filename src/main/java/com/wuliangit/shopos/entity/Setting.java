package com.wuliangit.shopos.entity;

public class Setting {
    private Integer settingId;

    private String name;

    private String key;

    private String value;

    public Setting(Integer settingId, String name, String key, String value) {
        this.settingId = settingId;
        this.name = name;
        this.key = key;
        this.value = value;
    }

    public Setting() {
        super();
    }

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}