package com.wuliangit.shopos.core.shiro;

import org.apache.shiro.session.mgt.SimpleSession;

/**
 * 自定义session，强化shiro默认session
 * Created by nilme on 2017/3/29.
 */
public class OnlineSession extends SimpleSession {


    //登录状态
    public static enum OnlineStatus {
        on_line("在线"), hidden("隐身"), force_logout("强制退出");
        private final String info;

        private OnlineStatus(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    //当前登录的用户Id
    private Long userId = 0L;

    private String username;

    /**
     * 用户浏览器类型
     */
    private String userAgent;

    /**
     * 在线状态
     */
    private OnlineStatus status = OnlineStatus.on_line;

    /**
     * 用户登录时系统IP
     */
    private String systemHost;

    public OnlineSession() {
        super();
    }

    public OnlineSession(String host) {
        super(host);
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public OnlineStatus getStatus() {
        return status;
    }

    public void setStatus(OnlineStatus status) {
        this.status = status;
    }

    public String getSystemHost() {
        return systemHost;
    }

    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost;
    }
}
