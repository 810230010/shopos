package com.wuliangit.shopos.common.shiro.mgt;

import org.apache.shiro.mgt.DefaultSubjectFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.subject.WebSubjectContext;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;

/**
 * Created by nilme on 2017/3/29.
 */
public class StatelessAndOnlineWebSubjectFactory extends DefaultSubjectFactory {

    private List<String> statelessUrl;

    public void setStatelessUrl(List<String> statelessUrl) {
        this.statelessUrl = statelessUrl;
    }

    public StatelessAndOnlineWebSubjectFactory() {
        super();
    }

    public Subject createSubject(SubjectContext context) {
        if (!(context instanceof WebSubjectContext)) {
            return super.createSubject(context);
        }
        WebSubjectContext wsc = (WebSubjectContext) context;
        SecurityManager securityManager = wsc.resolveSecurityManager();
        Session session = wsc.resolveSession();
        boolean sessionEnabled = wsc.isSessionCreationEnabled();
        PrincipalCollection principals = wsc.resolvePrincipals();
        boolean authenticated = wsc.resolveAuthenticated();
        String host = wsc.resolveHost();
        ServletRequest request = wsc.resolveServletRequest();
        ServletResponse response = wsc.resolveServletResponse();


        ShiroHttpServletRequest shiroHttpServletRequest = (ShiroHttpServletRequest)request;

        String requestURI = shiroHttpServletRequest.getRequestURI();

        AntPathMatcher matcher = new AntPathMatcher();

        boolean isStatelessUrl = false;

        //匹配是不是无状态请求
        for (String url : statelessUrl) {
            if (matcher.match(url,requestURI)){
                isStatelessUrl = true;
                break;
            }
        }

        if (isStatelessUrl){
//           无状态接口， 不创建session
            context.setSessionCreationEnabled(false);
        }
        WebDelegatingSubject webDelegatingSubject = new WebDelegatingSubject(principals, authenticated, host, session, sessionEnabled, request, response, securityManager);
        return webDelegatingSubject;
    }


    @Deprecated
    protected Subject newSubjectInstance(PrincipalCollection principals, boolean authenticated,
                                         String host, Session session,
                                         ServletRequest request, ServletResponse response,
                                         SecurityManager securityManager) {
        return new WebDelegatingSubject(principals, authenticated, host, session, true,
                request, response, securityManager);
    }

}
