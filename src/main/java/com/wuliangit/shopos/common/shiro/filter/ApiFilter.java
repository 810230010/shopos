package com.wuliangit.shopos.common.shiro.filter;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.realm.StatelessToken;
import com.wuliangit.shopos.common.shiro.realm.UserToken;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.entity.Member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by taoshanchang on 16/8/1.
 */
public class ApiFilter extends AccessControlFilter {

    static final String TOKEN = "token";
    private TokenManager tokenManager;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        String token = request.getParameter(TOKEN);

        // 判断用户是否已经登录
        Member member = (Member)tokenManager.getTokenData(token);

        if (member != null){
            Member user = WebUtil.getCurrentMember();
            if (user == null){
                SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER,user);
            }
            return true;
        }else {
            return false;
        }

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        getSubject(request, response).logout();
        saveRequestAndRedirectToLogin(request, response);
        return true;
    }

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }
}
