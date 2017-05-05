package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.SettingDTO;

import java.util.List;

/**
 * Created by nilme on 2017/5/1.
 */
public interface SettingService {
    /**
     * 更新邮箱设置
     *
     * @param mailServiceSite
     * @param mailUserName
     * @param mailPassword
     * @return
     */
    Integer updateMailSetting(String mailServiceSite, String mailUserName, String mailPassword);


    /**
     * 通过key获取设置的值
     *
     * @param key
     * @return
     */
    String getSetting(String key);

    /**
     * 更新文件存储配置
     *
     * @param accessKey
     * @param secretKey
     * @param bucket
     * @param domain
     */
    void updateBucketSetting(String accessKey, String secretKey, String bucket, String domain);

    /**
     * 支付设置更新
     * @param alipayPublicKey
     * @param appId
     * @param appPrivateKey
     * @param alipayCheck
     */
    void updatePaySetting(String alipayPublicKey, String appId, String appPrivateKey, String alipayCheck);

    /**
     * 获取邮箱的各项参数
     * @return
     */
    List<SettingDTO> getMailSetting();
}
