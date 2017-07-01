package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.dao.SettingMapper;
import com.wuliangit.shopos.dto.SettingDTO;
import com.wuliangit.shopos.entity.Setting;
import com.wuliangit.shopos.model.SysSetting;
import com.wuliangit.shopos.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nilme on 2017/5/1.
 */

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public Integer updateMailSetting(String mailServiceSite, String mailUserName, String mailPassword) {
        Integer siteResult = settingMapper.updateSetting(MailSender.MAIL_SERVICE_SITE, mailServiceSite);
        Integer nameResult = settingMapper.updateSetting(MailSender.MAIL_USERNAME, mailUserName);
        Integer passwordResult = settingMapper.updateSetting(MailSender.MAIL_PASSWORD, mailPassword);
        if (siteResult == 1 && nameResult == 1 && passwordResult == 1) {
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
        settingMapper.updateSetting(QiNiuUtils.BUCKET_ACCESSKEY, accessKey);
        settingMapper.updateSetting(QiNiuUtils.BUCKET_SECRETKEY, secretKey);
        settingMapper.updateSetting(QiNiuUtils.BUCKET_BUCKET, bucket);
        settingMapper.updateSetting(QiNiuUtils.BUCKET_DOMAIN, domain);
        //更新文件存储配置
        QiNiuUtils.updateAuth();
        MailSender.getSender().setUpdate(true);
    }

    @Override
    public void updatePaySetting(String alipayPublicKey, String appId, String appPrivateKey, String alipayCheck) {
        settingMapper.updateSetting(AliPay.ALIPAY_PUBLIC_KEY, alipayPublicKey);
        settingMapper.updateSetting(AliPay.ALIPAY_APP_ID, appId);
        settingMapper.updateSetting(AliPay.ALIPAY_APP_PRIVATE_KEY, appPrivateKey);
        settingMapper.updateSetting(AliPay.ALIPAY_CHECK, alipayCheck);
        //更新文件存储配置
        AliPay.updateAlipayClient();
    }

    @Override
    public List<SettingDTO> getMailSetting() {
        List<SettingDTO> result = new ArrayList<SettingDTO>();
        result.add(new SettingDTO(MailSender.MAIL_PASSWORD, settingMapper.getSetting(MailSender.MAIL_PASSWORD)));
        result.add(new SettingDTO(MailSender.MAIL_SERVICE_SITE, settingMapper.getSetting(MailSender.MAIL_SERVICE_SITE)));
        result.add(new SettingDTO(MailSender.MAIL_USERNAME, settingMapper.getSetting(MailSender.MAIL_USERNAME)));
        return result;
    }

    @Override
    public SysSetting getSysSetting() {
        SysSetting sysSetting = new SysSetting();

        sysSetting.setName(settingMapper.getSetting(SysSetting.SYS_SETTING_NAME));
        sysSetting.setKey(settingMapper.getSetting(SysSetting.SYS_SETTING_KEY));
        sysSetting.setDescription(settingMapper.getSetting(SysSetting.SYS_SETTING_DESCRIPTION));
        sysSetting.setQq(settingMapper.getSetting(SysSetting.SYS_SETTING_QQ));
        sysSetting.setTitle(settingMapper.getSetting(SysSetting.SYS_SETTING_TITLE));

        return sysSetting;
    }

    @Override
    public void updateSysSetting(SysSetting sysSetting) {
        settingMapper.updateSetting(SysSetting.SYS_SETTING_NAME,sysSetting.getName());
        settingMapper.updateSetting(SysSetting.SYS_SETTING_KEY,sysSetting.getKey());
        settingMapper.updateSetting(SysSetting.SYS_SETTING_DESCRIPTION,sysSetting.getDescription());
        settingMapper.updateSetting(SysSetting.SYS_SETTING_QQ,sysSetting.getQq());
        settingMapper.updateSetting(SysSetting.SYS_SETTING_TITLE,sysSetting.getTitle());
    }

    @Override
    public String getRegisterRegulation() {
        return settingMapper.getRegisterRegulation();
    }

    @Override
    public int updateRegulationContent(String regulationContent) {

        return settingMapper.updateRegisteryRegulation(regulationContent);
    }
}
