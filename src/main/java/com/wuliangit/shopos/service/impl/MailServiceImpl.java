package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.service.MailService;
import org.springframework.stereotype.Service;

/**
 * Created by nilme on 2017/4/29.
 */
@Service
public class MailServiceImpl implements MailService {

    @Override
    public void sendMail(String user, String templete) {
        try {
            MailSender.getSender().send(user,"测试",templete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
