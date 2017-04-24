package com.wuliangit.shopos.common.qiniu;

import com.qiniu.util.Auth;
import com.wuliangit.shopos.common.util.PropertyPlaceholder;
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

    private static String accessKey = PropertyPlaceholder.getProperty("qiniu.accessKey");
    private static String secretKey = PropertyPlaceholder.getProperty("qiniu.secretKey");
    private static String bucket = PropertyPlaceholder.getProperty("qiniu.bucket");
    public static String BASE_URL = PropertyPlaceholder.getProperty("qiniu.baseUrl");

    public static String getToken() {
        return getAuth().uploadToken(bucket);
    }

    public static Auth getAuth() {
        if (auth == null) {
            lock.lock();
            if (auth == null) {
                auth = Auth.create(accessKey, secretKey);
            }
            lock.unlock();
        }
        return auth;
    }

    public static String getRealUrl(String url) {
        if (url.contains("http://")){
            return url;
        }else{
            return BASE_URL+url;
        }
    }

    public static String getHttp(String url) {
        String responseMsg = null;
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


