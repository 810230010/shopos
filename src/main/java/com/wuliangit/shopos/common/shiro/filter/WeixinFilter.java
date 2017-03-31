package com.wuliangit.shopos.common.shiro.filter;

import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.entity.Member;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by taoshanchang on 16/8/1.
 */
public class WeixinFilter extends AccessControlFilter {

    static final String TOKEN = "token";

    private TokenManager tokenManager;

    @Autowired
    private WxMpService wxMpService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String token = request.getParameter(TOKEN);
        // 判断用户是否已经登录
        Member member = (Member)tokenManager.getTokenData(token);

        if (member != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //没有登录过跳转到微信授权登录页
        String loginUrl = wxMpService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_BASE, "base");
        WebUtils.issueRedirect(request, response, loginUrl);
        return false;
    }

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }
}
