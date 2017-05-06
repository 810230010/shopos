package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.dao.SettingMapper;
import com.wuliangit.shopos.dto.SettingDTO;
import com.wuliangit.shopos.service.MailService;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by nilme on 2017/4/29.
 */
@Service
public class MailServiceImpl implements MailService {

    @Override
    public void sendMail(String user, VelocityContext context, String templates) {
        try {
            MailSender.getSender().send(user,context,templates);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    @Override
    public void sendForegetPass(String to) {

    }
=======
//    @Override
//    public void sendForegetPass(String to) {
//
//    }
>>>>>>> 2487f0453c5ef144c3cec580ecb6fccdf9f26d14
}
