package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.StoreMailDTO;
import com.wuliangit.shopos.dto.StoreMessageDTO;

import java.util.List;

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

    /**
     * @Description: 获取未读消息条数
     * @Author: pangweichao
     * @Date: 11:31 2017/6/3
     * @Param: [storeId]
     * @return: java.lang.Integer
     */
    Integer getMessageCount(Integer storeId);

    /**
     * @Description: 获取消息列表页面数据
     * @Author: pangweichao
     * @Date: 13:20 2017/6/3
     * @Param: [searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreMailListDTO>
     */
    List<StoreMailDTO> getMailListDate(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, Integer storeId);

    /**
     * @Description: 删除指定邮件
     * @Author: pangweichao
     * @Date: 14:25 2017/6/3
     * @Param: [storeMessageId]
     * @return: java.lang.Integer
     */
    Integer deleteMessage(Integer storeMessageId);

    /**
     * @Description: 获取某条消息的详情
     * @Author: pangweichao
     * @Date: 14:47 2017/6/3
     * @Param: [messageId]
     * @return: com.wuliangit.shopos.dto.StoreMailDTO
     */
    StoreMailDTO detailMail(Integer messageId,Integer storeId);

    /**
     * @Description: 更新是否阅读的状态
     * @Author: pangweichao
     * @Date: 15:49 2017/6/3
     * @Param: [storeMessageId]
     * @return: java.lang.Integer
     */
    Integer updateReadFlag(Integer storeMessageId);
}
