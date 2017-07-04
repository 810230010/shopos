package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.ali.sms.SMSSender;
import com.wuliangit.shopos.common.cache.SpringCacheManager;
import com.wuliangit.shopos.service.SMSService;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by nilme on 2017/3/22.
 */

@Service
public class SMSServiceImpl implements SMSService {

    //超时时间
    private static final String timeout = "10";

    @Autowired
    private SpringCacheManager springCacheManager;

    @Override
    public boolean sendRegisterCode(String phone) {
        String code = this.getRandomCode();
        HashMap<String, String> data = new HashMap<>();
        data.put("code", this.getRandomCode());
        data.put("time", timeout);

        boolean res = SMSSender.send(phone, SMSSender.CODE_REGISTER, data);
        if (res) {
            getSmsCache().put(phone, code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendtRepassCode(String phone) {
        String code = this.getRandomCode();

        HashMap<String, String> data = new HashMap<>();
        data.put("code", this.getRandomCode());
        data.put("time", timeout);

        boolean res = SMSSender.send(phone, SMSSender.CODE_REPASS, data);
        if (res) {
            getSmsCache().put(phone, code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getCheckCode(String phone) {
        String cacheCode = (String) getSmsCache().get(phone);
        return cacheCode;
    }

    @Override
    public boolean sendStoreBindCode(String phone) {
        String code = this.getRandomCode();

        HashMap<String, String> data = new HashMap<>();
        data.put("code", this.getRandomCode());
        data.put("time", timeout);

        boolean res = SMSSender.send(phone, SMSSender.CODE_STORE_BIND, data);
        if (res) {
            getSmsCache().put(phone, code);
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取6位随机验证码
     *
     * @return
     */
    private String getRandomCode() {
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        int code = tmp % (999999 - 100000 + 1) + 100000;
        return code + "";
    }

    /**
     * 获取短信缓存
     *
     * @return
     */
    private Cache<Object, Object> getSmsCache() {
        Cache<Object, Object> cache = springCacheManager.getCache(SMSSender.DEFAULT_CACHE_NAME);
        return cache;
    }


}
