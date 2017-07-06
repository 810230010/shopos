package com.wuliangit.shopos.common.qiniu;

import com.qiniu.util.Auth;
import com.wuliangit.shopos.common.util.PropertyPlaceholder;
import com.wuliangit.shopos.common.util.SpringUtils;
import com.wuliangit.shopos.service.SettingService;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by taoshanchang on 16/8/19.
 */

public class QiNiuUtils {

    private static Auth auth;
    private static ReentrantLock lock = new ReentrantLock();

    public static final String BUCKET_ACCESSKEY = "BUCKET_ACCESSKEY";
    public static final String BUCKET_SECRETKEY = "BUCKET_SECRETKEY";
    public static final String BUCKET_BUCKET = "BUCKET_BUCKET";
    public static final String BUCKET_DOMAIN = "BUCKET_DOMAIN";

    private static String accessKey = PropertyPlaceholder.getProperty("qiniu.accessKey");
    private static String secretKey = PropertyPlaceholder.getProperty("qiniu.secretKey");
    private static String BUCKET = PropertyPlaceholder.getProperty("qiniu.bucket");
    private static String BASE_URL = PropertyPlaceholder.getProperty("qiniu.baseUrl");

    public static String getToken() {
        return getAuth().uploadToken(BUCKET);
    }

    public static Auth getAuth() {
        if (auth == null) {
            lock.lock();
            if (auth == null) {
                SettingService settingService = SpringUtils.getBean(SettingService.class);
                accessKey = settingService.getSetting(BUCKET_ACCESSKEY);
                secretKey = settingService.getSetting(BUCKET_SECRETKEY);
                BUCKET = settingService.getSetting(BUCKET_BUCKET);
                BASE_URL = settingService.getSetting(BUCKET_DOMAIN);
                auth = Auth.create(accessKey, secretKey);
            }
            lock.unlock();
        }
        return auth;
    }

    public static Auth updateAuth() {
        auth = null;
        return QiNiuUtils.getAuth();
    }

    public static String getBaseUrl() {
        if (auth == null) {
            getAuth();
        }
        return BASE_URL;
    }

    public static String resizeImges(String imgs) {
        String[] strings = imgs.split("&&");
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (String url : strings) {
            if (flag == 0) {
                sb.append(url + "-apiResize");
                flag = 1;
            } else {
                sb.append("&&").append(url + "-apiResize");
            }

        }
        return sb.toString();
    }

    public static String resizeImge(String img) {
        return img + "-apiResize";
    }


    public static String getRealUrl(String url) {
        if (url.contains("http://")) {
            return url;
        } else {
            return BASE_URL + url;
        }
    }

}


