package com.wuliangit.shopos.common.shiro;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    @Autowired
    private MemberService memberService;


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

        HashMap<String, Object> hashUser = (HashMap) token.getPrincipal();
        String username = (String) hashUser.get("username");
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

        //如果不是tokne登录需要保存用户session
        if (userToken.getLoginType() != UserToken.LoginType.TOKEN) {
            Member member = memberService.getByUsername(username);
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, member);
        } else {

        }
        return matches;
    }
}
