package com.wuliangit.shopos.common.shiro.token;

/**
 * Created by nilme on 2017/3/30.
 */
public interface TokenManager<T,D> {

    /**
     * 创建token
     *
     * @param userId
     */
    String createToken(T userId);

    /**
     * 获取token数据
     *
     * @param userId
     * @return
     */
    String getToken(T userId);

    /**
     * 更新token数据
     *
     * @param userId
     * @param token
     */
    void updateToken(T userId, String token);

    /**
     * 删除token
     *
     * @param userId
     */
    void deleteToken(T userId);

    /**
     * 创建tokne数据
     *
     * @param token
     * @param data
     */
    void createTokenData(String token, D data);

    /**
     * 获取token数据
     *
     * @param token
     * @return
     */
    D getTokenData(String token);

    /**
     * 删除token数据
     *
     * @param token
     */
    void deleteTokenData(String token);


    /**
     * 更新token数据
     *
     * @param token
     */
    void updateTokenData(String token, D data);

}
