package com.wuliangit.shopos.common.sms;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2017/3/22.
 */
public class YXSMSSender implements SMSSender {

    private static CCPRestSmsSDK ccpRestSmsSDK;
    private static ReentrantLock lock = new ReentrantLock();

    public static final String SuccessCode = "000000";
    //default cacheName
    public static final String DEFAULT_CACHE_NAME = "sms-session";

    @Value("${sms.cacheName}")
    private String cacheName;
    @Value("${sms.url}")
    private String url;
    @Value("${sms.port}")
    private String port;
    @Value("${sms.accountSid}")
    private String accountSid;
    @Value("${sms.authToken}")
    private String authToken;
    @Value("${sms.appId}")
    private String appId;
    @Value("${sms.resignId}")
    private  String resignId;

    @Override
    public boolean send(String phone, String templateId, String[] datas) {
        HashMap<String, Object> result = getSDK().sendTemplateSMS(phone, templateId, datas);
        if (SuccessCode.equals(result.get("statusCode"))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getCacheName() {
        if (StringUtils.isEmpty(this.cacheName)){
            return DEFAULT_CACHE_NAME;
        }
        return cacheName;
    }

    private CCPRestSmsSDK getSDK() {
        if (ccpRestSmsSDK == null) {
            lock.lock();
            if (ccpRestSmsSDK == null) {
                ccpRestSmsSDK = new CCPRestSmsSDK();
                ccpRestSmsSDK.init(url,port);
                ccpRestSmsSDK.setAccount(accountSid,authToken);
                ccpRestSmsSDK.setAppId(appId);
            }
            lock.unlock();
        }
        return ccpRestSmsSDK;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}
