package com.wuliangit.shopos.core.filter;

import com.alaban.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SysUserFilter extends AccessControlFilter {

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if(isLoginRequest(request,response)){
            return true;
        }
        if(SecurityUtils.getSubject().isAuthenticated()){
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        saveRequestAndRedirectToLogin(request,response);
        return false;
    }
}
