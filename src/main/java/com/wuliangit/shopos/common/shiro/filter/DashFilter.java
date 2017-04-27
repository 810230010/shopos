package com.wuliangit.shopos.common.shiro.filter;

import com.google.gson.Gson;
import com.wuliangit.shopos.common.controller.RestResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class DashFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (isLoginRequest(request, response)) {
            return true;
        }
        if (SecurityUtils.getSubject().isAuthenticated()) {
            if (SecurityUtils.getSubject().hasRole("admin") || SecurityUtils.getSubject().hasRole("store")) {
                return true;
            } else {
                System.out.println("没有管理员角色或者没有店铺角色，被拦截！！！");
                return false;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        RestResult result = new RestResult();

        result.setCode(401);
        result.setMsg("unauthentication request! pelease login before request the api");

        Gson gson = new Gson();
        httpResponse.getWriter().write(gson.toJson(result));
        return false;
    }

}
