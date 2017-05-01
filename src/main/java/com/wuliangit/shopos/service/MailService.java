package com.wuliangit.shopos.service;

/**
 * Created by nilme on 2017/4/29.
 */
public interface MailService {

    /**
     * 发送邮件
     *
     * @param user     用户邮箱
     * @param template 模板名称
     */
    void sendMail(String user, String template);




}
