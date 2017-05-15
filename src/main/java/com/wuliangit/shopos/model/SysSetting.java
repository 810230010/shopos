package com.wuliangit.shopos.model;

/**
 * Created by nilme on 2017/5/15.
 */
public class SysSetting {

    public final static String SYS_SETTING_NAME = "SYS_SETTING_NAME";
    public final static String SYS_SETTING_TITLE = "SYS_SETTING_TITLE";
    public final static String SYS_SETTING_KEY = "SYS_SETTING_KEY";
    public final static String SYS_SETTING_DESCRIPTION = "SYS_SETTING_DESCRIPTION";
    public final static String SYS_SETTING_QQ = "SYS_SETTING_QQ";


    //系统商店名称
    private String name;
    //系统商店标题
    private String title;
    //系统商店关键字
    private String key;
    //系统商店描述
    private String description;
    //系统客服QQ号码
    private String qq;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
