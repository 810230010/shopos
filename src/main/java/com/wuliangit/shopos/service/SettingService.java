package com.wuliangit.shopos.service;

/**
 * Created by nilme on 2017/5/1.
 */
public interface SettingService {
    /**
     * 更新邮箱设置
     * @param mailServiceSite
     * @param mailUserName
     * @param mailPassword
     * @return
     */
    Integer updateMailSetting(String mailServiceSite, String mailUserName, String mailPassword);


    /**
     * 通过key获取设置的值
     * @param key
     * @return
     */
    String getSetting(String key);
}
