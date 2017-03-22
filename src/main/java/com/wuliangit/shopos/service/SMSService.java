package com.wuliangit.shopos.service;

/**
 * Created by nilme on 2017/3/22.
 */
public interface SMSService {

    /**
     * 注册获取验证
     * @param phone
     * @return
     */
    boolean sendRegisterCode(String phone);

    /**
     * 修改密码获取验证码
     * @param phone
     * @return
     */
    boolean sendtRepassCode(String phone);
}
