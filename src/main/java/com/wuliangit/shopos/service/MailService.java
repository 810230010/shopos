package com.wuliangit.shopos.service;

import org.apache.velocity.VelocityContext;

import java.util.Map;

/**
 * Created by nilme on 2017/4/29.
 */
public interface MailService {

    /**
     * 发送邮件
     *
     * @param user     用户邮箱
     * @param context  页面的动态内容
     */
    void sendMail(String user, VelocityContext context);


    void sendForegetPass(String to);

}
