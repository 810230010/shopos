package com.wuliangit.shopos.common.shiro.token;

import com.wuliangit.shopos.common.cache.SpringCacheManager;
import com.wuliangit.shopos.entity.Member;
import org.apache.shiro.cache.Cache;

import java.util.UUID;

/**
 * Created by nilme on 2017/3/30.
 */
public class EhcacheTokenManager implements TokenManager<Integer,Member> {

    private SpringCacheManager cacheManager;

    private String cacheName;

    @Override
    public String createToken(Integer userId){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        Cache<Object, Object> cache = cacheManager.getCache(cacheName);
        cache.put(userId, token);
        return token;
    }

    @Override
    public String getToken(Integer userId) {
        Cache<Object, Object> cache = cacheManager.getCache(cacheName);
        return (String)cache.get(userId);
    }

    @Override
    public void updateToken(Integer userId, String token) {

    }

    @Override
    public void deleteToken(Integer userId) {

    }

    @Override
    public void createTokenData(String token, Member data) {

    }

    @Override
    public Member getTokenData(String token) {
        return null;
    }

    @Override
    public void deleteTokenData(String token) {

    }

    @Override
    public void updateTokenData(String token, Member data) {

    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public void setCacheManager(SpringCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
