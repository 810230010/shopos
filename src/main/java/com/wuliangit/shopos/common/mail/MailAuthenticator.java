package com.wuliangit.shopos.common.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by 26229 on 2017/5/1.
 */
public class MailAuthenticator extends Authenticator {

    private String username;
    //密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

}
