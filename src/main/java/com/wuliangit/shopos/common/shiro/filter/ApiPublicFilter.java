package com.wuliangit.shopos.common.shiro.filter;

import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.entity.Member;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static com.wuliangit.shopos.common.CoreConstants.SESSION_CURRENT_USERID;

/**
 * Created by taoshanchang on 16/8/1.
 */
public class ApiPublicFilter extends AccessControlFilter {

    static final String SIGN = "sign";
    static final String TIMESTAMP = "timestamp";
    static final String USERID = "userId";

    private TokenManager<Integer, Member> tokenManager;

    public void setTokenManager(TokenManager<Integer, Member> tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String sign = request.getParameter(SIGN);
        String timestamp = request.getParameter(TIMESTAMP);
        String userIdStr = request.getParameter(USERID);

        Integer userId = null;
        if (!StringUtils.isEmpty(userIdStr)) {
            userId = Integer.parseInt(userIdStr);
        }

        if (userId != null) {
            // 判断用户是否已经登录
            String serverToken = tokenManager.getToken(userId);
            if (serverToken != null) {
                Session session = SecurityUtils.getSubject().getSession();
                session.setAttribute(SESSION_CURRENT_USERID, userId);
            }
        }

        return true;

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }

}
