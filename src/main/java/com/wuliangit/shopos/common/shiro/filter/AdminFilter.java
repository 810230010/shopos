package com.wuliangit.shopos.common.shiro.filter;

import com.wuliangit.shopos.common.shiro.realm.AdminRealm;
import com.wuliangit.shopos.common.shiro.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sound.midi.Soundbank;

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
        getSubject(request, response).logout();
        saveRequestAndRedirectToLogin(request,response);
        return false;
    }

}
