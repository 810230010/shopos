package com.wuliangit.shopos.common.shiro.filter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdminFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if(isLoginRequest(request,response)){
            return true;
        }
        if(SecurityUtils.getSubject().isAuthenticated()){
            if (SecurityUtils.getSubject().hasRole("admin")){
                return true;
            }else{
                System.out.println("没有管理员角色，被拦截！！！");
                return false;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        saveRequestAndRedirectToLogin(request,response);
        return false;
    }

}
