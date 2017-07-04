package com.wuliangit.shopos.common.ali.sms;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import com.wuliangit.shopos.common.ali.AcsClient;
import com.wuliangit.shopos.common.ali.sms.model.SendSmsRequest;
import com.wuliangit.shopos.common.ali.sms.model.SendSmsResponse;

import java.util.HashMap;

/**
 * Created by nilme on 2017/7/4.
 */
public class SMSSender {

    private static final String SignName = "后悔要商城";

    //default cacheName
    public static final String DEFAULT_CACHE_NAME = "sms-session";

    public static final String CODE_REGISTER = "SMS_75860122";
    public static final String CODE_STORE_BIND = "SMS_75860122";
    public static final String CODE_REPASS = "SMS_75860122";


    private static Gson gson = new Gson();

    public static boolean send(String phone, String templateId, HashMap<String,String> datas){

        SendSmsRequest request = new SendSmsRequest();

        request.setPhoneNumbers(phone);

        request.setSignName(SignName);

        request.setTemplateCode(templateId);

        request.setTemplateParam(gson.toJson(datas));

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        try {
            SendSmsResponse sendSmsResponse = AcsClient.getAcsClient().getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return true;
            }else{
                return false;
            }
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

}
