package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.cache.SpringCacheManager;
import com.wuliangit.shopos.common.sms.SMSSender;
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
    private SMSSender smsSender;

    @Autowired
    private SpringCacheManager springCacheManager;

    @Override
    public boolean sendRegisterCode(String phone) {
        String code = this.getRandomCode();
        String timeout = "10";
        boolean res = smsSender.send(phone, "1", new String[]{timeout, code});
        if (res) {
            Cache<Object, Object> cache = springCacheManager.getCache(smsSender.getCacheName());
            cache.put(phone, code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendtRepassCode(String phone) {
        String code = this.getRandomCode();
        String timeout = "10";
        boolean res = smsSender.send(phone, "1", new String[]{timeout, code});
        if (res) {
            Cache<Object, Object> cache = springCacheManager.getCache(smsSender.getCacheName());
            cache.put(phone, code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getCheckCode(String phone) {
        Cache<Object, Object> cache = springCacheManager.getCache(smsSender.getCacheName());
        String cacheCode = (String)cache.get(phone);
        return cacheCode;
    }

    @Override
    public boolean sendStoreBindCode(String phone) {
        String code = this.getRandomCode();
        String timeout = "10";
        boolean res = smsSender.send(phone, "178586", new String[]{timeout, code});
        if (res) {
            Cache<Object, Object> cache = springCacheManager.getCache(smsSender.getCacheName());
            cache.put(phone, code);
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取6位随机验证码
     * @return
     */
    private String getRandomCode(){
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        int code = tmp % (999999 - 100000 + 1) + 100000;
        return  code+"";
    }
}
