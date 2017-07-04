package com.wuliangit.shopos.common.ali;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.wuliangit.shopos.common.ali.sms.SMSSender;
import com.wuliangit.shopos.common.ali.sms.model.SendSmsRequest;
import com.wuliangit.shopos.common.ali.sms.model.SendSmsResponse;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2017/7/4.
 */
public class AcsClient {

    private static IAcsClient acsClient;
    private static ReentrantLock lock = new ReentrantLock();

    private static final String PRODUCT = "Dysmsapi";
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    private static final String accessKeyId = "NsppEqjIVS3XZ3Gl";
    private static final String accessKeySecret = "cjTXVq5wpXiovdwWfEVq9kEAD1NzK5";

    private static final String ENDPOINT = "cn-hangzhou";

    public static IAcsClient getAcsClient() {

        if (acsClient == null) {
            lock.lock();
            if (acsClient == null) {
                //设置超时时间-可自行调整
                System.setProperty("sun.net.client.defaultConnectTimeout", "6000");
                System.setProperty("sun.net.client.defaultReadTimeout", "6000");
                //初始化ascClient,暂时不支持多region
                IClientProfile profile = DefaultProfile.getProfile(ENDPOINT, accessKeyId, accessKeySecret);
                try {
                    DefaultProfile.addEndpoint(ENDPOINT, ENDPOINT, PRODUCT, DOMAIN);
                } catch (ClientException e) {
                    e.printStackTrace();
                }
                acsClient = new DefaultAcsClient(profile);
            }
            lock.unlock();
        }
        return acsClient;
    }


    /**
     * test
     * @param args
     * @throws ClientException
     */
    public static void main(String[] args) throws ClientException {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("code","999999");
        stringStringHashMap.put("time","10");

        SMSSender.send("18066265836","SMS_75860122",stringStringHashMap);

    }
}
