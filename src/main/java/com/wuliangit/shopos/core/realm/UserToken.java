package com.wuliangit.shopos.core.realm;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.HashMap;

/**
 * 用于和其他用户区分开验证.
 */
public class UserToken implements AuthenticationToken {

    private String username;

    private LoginType loginType;

    private char[] password;

    public enum LoginType {
        ADMIN(0), MEMBER(1);
        private final int type;
        private LoginType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }
    }

    public UserToken(final String username, final String password, LoginType loginType) {
        this.username = username;
        this.loginType = loginType;
        this.password = (password != null ? password.toCharArray() : null);
    }

    @Override
    public Object getPrincipal() {
        HashMap<String, Object> user = new HashMap<>();
        user.put("username",username);
        user.put("loginType",loginType);
        return user;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public LoginType getLoginType() {
        return loginType;
    }
}
