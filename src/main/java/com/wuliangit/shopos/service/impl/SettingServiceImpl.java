package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.dao.SettingMapper;
import com.wuliangit.shopos.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nilme on 2017/5/1.
 */

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public Integer updateMailSetting(String mailServiceSite, String mailUserName, String mailPassword) {
        Integer siteResult =  settingMapper.updateSetting(MailSender.MAIL_SERVICE_SITE,mailServiceSite);
        Integer nameResult = settingMapper.updateSetting(MailSender.MAIL_USERNAME,mailUserName);
        Integer passwordResult = settingMapper.updateSetting(MailSender.MAIL_PASSWORD,mailPassword);
        if(siteResult == 1 && nameResult == 1 && passwordResult == 1){
            MailSender.getSender().setUpdate(true);
            return 1;
        }
        return 0;
    }

    @Override
    public String getSetting(String key) {
        return settingMapper.getSetting(key);
    }

    @Override
    public void updateBucketSetting(String accessKey, String secretKey, String bucket, String domain) {
        settingMapper.updateSetting(QiNiuUtils.BUCKET_ACCESSKEY,accessKey);
        settingMapper.updateSetting(QiNiuUtils.BUCKET_SECRETKEY,secretKey);
        settingMapper.updateSetting(QiNiuUtils.BUCKET_BUCKET,bucket);
        settingMapper.updateSetting(QiNiuUtils.BUCKET_DOMAIN,domain);
        //更新文件存储配置
        QiNiuUtils.updateAuth();
        MailSender.getSender().setUpdate(true);
    }
}
