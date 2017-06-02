package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.StoreMessageDTO;

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
    String sendMail(StoreMessageDTO storeMessageDTO);

}
