package com.wuliangit.shopos.common.shiro;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.AdminService;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UserToken userToken = null;
        if (token instanceof UserToken) {
            userToken = (UserToken) token;
        } else {
            new Exception("token 不匹配");
        }

        String username = userToken.getUsername();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if (retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        }

        return matches;
    }
}
