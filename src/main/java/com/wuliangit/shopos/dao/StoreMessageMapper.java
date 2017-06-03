package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.StoreMailDTO;
import com.wuliangit.shopos.entity.StoreMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMessageMapper extends BaseMapper<StoreMessage , Integer> {
    /**
     * @Description: 批量插入数据
     * @Author: pangweichao
     * @Date: 16:45 2017/5/19
     * @Param:
     * @return:
     */
    Integer insertMessage(List<StoreMessage> storeMessages);

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
     * @Param: [searchKey, orderColumn, orderType]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreMailListDTO>
     */
    List<StoreMailDTO> getMailListDate(@Param("searchKey") String searchKey,
                                       @Param("orderColumn") String orderColumn,
                                       @Param("orderType") String orderType,
                                       @Param("storeId") Integer storeId);

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
    StoreMailDTO detailMail(@Param("messageId") Integer messageId,@Param("storeId") Integer storeId);

    /**
     * @Description: 更新是否阅读的状态
     * @Author: pangweichao
     * @Date: 15:49 2017/6/3
     * @Param: [storeMessageId]
     * @return: java.lang.Integer
     */
    Integer updateReadFlag(Integer storeMessageId);
}