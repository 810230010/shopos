package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.service.MailService;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by nilme on 2017/4/29.
 */
@Service
public class MailServiceImpl implements MailService {


    @Override
    public void sendMail(String user, VelocityContext context) {
        try {
            MailSender.getSender().send(user,context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendForegetPass(String to) {


    }
}
