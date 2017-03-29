package com.wuliangit.shopos.common.shiro.filter;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by taoshanchang on 16/8/1.
 */
public class WeixinFilter extends PathMatchingFilter {

    @Autowired
    private WxMpService wxMpService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        // 判断用户是否已经登录
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return true;
        }
//        没有登录过跳转到微信授权登录页
        String loginUrl = wxMpService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_BASE, "base");
        try {
            WebUtils.issueRedirect(request, response, loginUrl);
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
