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
     * @param context  模板的动态内容
     * @param templates  邮件模板
     *
     */
    void sendMail(String user, VelocityContext context, String templates);


}
