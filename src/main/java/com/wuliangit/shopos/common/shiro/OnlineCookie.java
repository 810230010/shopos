package com.wuliangit.shopos.common.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        value = request.getParameter(name);

        //重写cookie，使其可以将cookie作为参数放在url或者消息体里面
        if (!StringUtils.isEmpty(value)){
            return value;
        }

        javax.servlet.http.Cookie cookie = getCookie(request, name);

        if (cookie != null) {
            value = cookie.getValue();
        }

        return value;
    }


    private static javax.servlet.http.Cookie getCookie(HttpServletRequest request, String cookieName) {
        javax.servlet.http.Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
