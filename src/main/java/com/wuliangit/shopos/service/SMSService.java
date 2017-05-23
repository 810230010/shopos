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

    /**
     * 获取缓存的验证码
     * @param phone
     * @return
     */
    String getCheckCode(String phone);

    /**
     * 店铺绑定会员验证码
     * @param phone
     * @return
     */
    boolean sendStoreBindCode(String phone);
}
