package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.StoreMessage;

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
}