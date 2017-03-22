package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.core.cache.SpringCacheManager;
import com.wuliangit.shopos.core.sms.Sender;
import com.wuliangit.shopos.service.SMSService;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by nilme on 2017/3/22.
 */

@Service
public class SMSServiceImpl implements SMSService {

    @Autowired
    private Sender sender;

    @Autowired
    private SpringCacheManager springCacheManager;


    @Override
    public boolean sendRegisterCode(String phone) {

        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        int code = tmp % (999999 - 100000 + 1) + 100000;

        String timeout = "10";

        boolean res = sender.send(phone, "1", new String[]{timeout, code + ""});
        if (res) {
            Cache<Object, Object> cache = springCacheManager.getCache("sms-session");
            cache.put("phone", code + "");
            return true;
        } else {
            return false;
        }
    }
}
