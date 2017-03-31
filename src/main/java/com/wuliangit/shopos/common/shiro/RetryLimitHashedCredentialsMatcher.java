package com.wuliangit.shopos.common.shiro;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
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

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    private TokenManager tokenManager;

    @Autowired
    private MemberService memberService;

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

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

        if (userToken.getLoginType() == UserToken.LoginType.TOKEN) {
            Member user = (Member) tokenManager.getTokenData(userToken.getUsername());

            if (user == null) {
                return false;
            }
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, user);
            tokenManager.createToken(SecurityUtils.getSubject().getSession().getId().toString(), user);
            return true;
        } else {
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
            Member member = memberService.getByUsername(username);
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, member);
            String tokenkey  = SecurityUtils.getSubject().getSession().getId().toString();
            tokenManager.createToken(tokenkey, member);
            return matches;
        }

    }
}
