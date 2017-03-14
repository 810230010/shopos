package com.wuliangit.shopos.core.realm;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by taoshanchang on 16/8/1.
 */
public class WeixinLoginToken implements AuthenticationToken {

    private String username;

    private  char[] password;

    public WeixinLoginToken(final String username, final String password) {
        this.username = username;
        this.password = (password != null ? password.toCharArray() : null);
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
