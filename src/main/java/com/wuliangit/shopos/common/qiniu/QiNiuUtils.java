package com.wuliangit.shopos.common.qiniu;

import com.qiniu.util.Auth;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by taoshanchang on 16/8/19.
 */

public class QiNiuUtils {

    private static Auth auth;
    private static ReentrantLock lock = new ReentrantLock();

    private static String accessKey = "";
    private static String secretKey = "";
    private static String bucket = "";
    public static String BASE_URL = "";

    public static String getToken() {
        return getAuth().uploadToken(bucket);
    }

    public static Auth getAuth() {
        if (auth == null) {
            lock.lock();
            if (auth == null) {
                Properties prop = new Properties();
                InputStream in = QiNiuUtils.class.getClassLoader().getResourceAsStream("shopos.properties");
                try {
                    prop.load(in);
                    accessKey = prop.getProperty("qiniu.accessKey").trim();
                    secretKey = prop.getProperty("qiniu.secretKey").trim();
                    bucket = prop.getProperty("qiniu.bucket").trim();
                    BASE_URL = prop.getProperty("qiniu.baseUrl").trim();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                auth = Auth.create(accessKey, secretKey);
            }
            lock.unlock();
        }
        return auth;
    }


    public static String getRealUrls(String urls) {
        if (StringUtils.isEmpty(urls)){
            return null;
        }

        String[] split = urls.split("&&");
        StringBuffer bf = new StringBuffer();
        for (String s : split) {
            bf.append(BASE_URL+ s + "&&");
        }
        String res = bf.toString();
        int i = res.lastIndexOf("&&");
        return res.substring(0,i);
    }

    public static String getRealUrl(String url) {
        return BASE_URL+url;
    }

    public static String getHttp(String url) {
        String responseMsg = "";
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
        try {
            httpClient.executeMethod(getMethod);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = getMethod.getResponseBodyAsStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while((len=in.read(buf))!=-1){
                out.write(buf, 0, len);
            }
            responseMsg = out.toString("UTF-8");
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放连接
            getMethod.releaseConnection();
        }
        return responseMsg;
    }

}


