package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.SettingMapper;
import com.wuliangit.shopos.dao.StoreMessageMapper;
import com.wuliangit.shopos.dto.SettingDTO;
import com.wuliangit.shopos.dto.StoreMessageDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreMessage;
import com.wuliangit.shopos.service.MailService;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by nilme on 2017/4/29.
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private StoreMessageMapper storeMessageMapper;

//    @Override
//    public String sendMail(StoreMessageDTO storeMessageDTO) {
//        try {
//            VelocityContext context = new VelocityContext();
//            context.put("title",storeMessageDTO.getTitle());
//            context.put("content",storeMessageDTO.getContent());
//            MailSender.getSender().send(mail,context,templates);
//            String[] name = username.split(",");
//            String[] userId = id.split(",");
//            Admin admin = (Admin)WebUtil.getSession().getAttribute(CoreConstants.SESSION_CURRENT_ADMIN);
//            List<StoreMessage> storeMessages = new ArrayList<StoreMessage>();
//            for(int i=0;i<name.length;i++){
//                storeMessages.add();
//            }
//            Integer info = storeMessageMapper.insertMessage(storeMessages);
//            if(!(info > 0))return "error";
//            return "ok";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//    }
}
