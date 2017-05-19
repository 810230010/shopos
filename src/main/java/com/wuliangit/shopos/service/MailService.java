package com.wuliangit.shopos.service;

import org.apache.velocity.VelocityContext;

import java.util.List;
import java.util.Map;

/**
 * Created by nilme on 2017/4/29.
 */
public interface MailService {

    /**
     * @Description: 发送邮件
     * @Author: pangweichao
     * @Date: 14:45 2017/5/19
     * @Param: [user, title, content, templates]
     * @return: java.lang.String
     */
    String sendMail(String username,String id,String mail , String title, String content, String templates);

}
