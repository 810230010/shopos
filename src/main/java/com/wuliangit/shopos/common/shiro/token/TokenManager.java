package com.wuliangit.shopos.common.shiro.token;

/**
 * Created by nilme on 2017/3/30.
 */
public interface TokenManager {

    /**
     * 创建token
     *
     * @return
     */
    void createToken(String token, Object data);

    /**
     * 获取token数据
     *
     * @param token
     * @return
     */
    Object getTokenData(String token);

    /**
     * 更新token数据
     *
     * @param token
     * @param object
     */
    void updateTokenData(String token, Object object);

    /**
     * 删除token
     *
     * @param token
     */
    void deleteToken(String token);

}
