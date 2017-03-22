package com.wuliangit.shopos.core.sms;

import org.apache.shiro.cache.Cache;

/**
 * 短信接口
 * Created by nilme on 2017/3/22.
 */
public interface Sender {

    /**
     * 发送短信接口
     *
     * @param phone      目标手机
     * @param templateId 模板id
     * @param datas      短信参数
     * @return
     */
    boolean send(String phone, String templateId, String[] datas);

}
