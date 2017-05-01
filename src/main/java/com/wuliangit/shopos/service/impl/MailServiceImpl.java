package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.mail.TSCMailSender;
import com.wuliangit.shopos.dao.SettingMapper;
import com.wuliangit.shopos.entity.Setting;
import com.wuliangit.shopos.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/4/29.
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public void sendMail(String user, String templete) {
        String mailServiceSite = settingMapper.getSetting("mailServiceSite");
        String mailUserName = settingMapper.getSetting("mailUserName");
        String mailPassword = settingMapper.getSetting("mailPassword");
        try {
            TSCMailSender.getSender(mailServiceSite,mailUserName,mailPassword).send(user,"测试",templete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer updateMail(String mailServiceSite, String mailUserName, String mailPassword) {
        Integer siteResult =  settingMapper.updateMail("mailServiceSite",mailServiceSite);
        Integer nameResult = settingMapper.updateMail("mailUserName",mailUserName);
        Integer passwordResult = settingMapper.updateMail("mailPassword",mailPassword);
        if(siteResult == 1 && nameResult == 1 && passwordResult == 1){
            TSCMailSender.updateFlag();
            return 1;
        }
        return 0;
    }
}
