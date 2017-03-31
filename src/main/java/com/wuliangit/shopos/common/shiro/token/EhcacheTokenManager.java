package com.wuliangit.shopos.common.shiro.token;

import com.wuliangit.shopos.common.cache.SpringCacheManager;
import org.apache.shiro.cache.Cache;

import java.util.UUID;

/**
 * Created by nilme on 2017/3/30.
 */
public class EhcacheTokenManager implements TokenManager {

    private SpringCacheManager cacheManager;

    private String cacheName;

    @Override
    public void createToken(String token,Object data){
//        String token = UUID.randomUUID().toString().replaceAll("-", "");
        Cache<Object, Object> cache = cacheManager.getCache(cacheName);
        cache.put(token, data);
//        return token;
    }

    @Override
    public Object getTokenData(String token) {
        Cache<Object, Object> cache = cacheManager.getCache(cacheName);
        return cache.get(token);
    }

    @Override
    public void updateTokenData(String token, Object object) {

    }

    @Override
    public void deleteToken(String token) {

    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public void setCacheManager(SpringCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
