package com.wuliangit.shopos.core.shiro;

import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nilme on 2017/3/29.
 */
public class OnlineCookie extends SimpleCookie {


    private static final transient Logger log = LoggerFactory.getLogger(SimpleCookie.class);

    public OnlineCookie(String name) {
        super(name);
    }

    @Override
    public String readValue(HttpServletRequest request, HttpServletResponse ignored) {
        String name = getName();
        String value = null;

        Cookie httpCookie = null;

        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    httpCookie = cookie;
                }
            }
        }

//        if(httpCookie == null){
//            String sessionId =  request.getParameter(name);
//            httpCookie = new Cookie(name, sessionId);
//        }
//
//
//        if (httpCookie != null) {
//            value = httpCookie.getValue();
//            log.debug("Found '{}' cookie value [{}]", name, value);
//        } else {
//            log.trace("No '{}' cookie value", name);
//        }

        return request.getParameter(name);
    }
}
