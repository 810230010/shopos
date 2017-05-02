package com.wuliangit.shopos.common.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import com.wuliangit.shopos.common.util.SpringUtils;
import com.wuliangit.shopos.service.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pangweichao on 2017/5/1.
 */
public class MailSender {

    private static MailSender mailSender;

    private boolean isUpdate = false;
    private static ReentrantLock lock = new ReentrantLock();
    Logger logger = LoggerFactory.getLogger(MailSender.class);
    //发送邮件的props文件
    private final transient Properties props = System.getProperties();
    //邮件服务器登录验证
    private transient MailAuthenticator authenticator;
    //邮箱session
    private transient Session session;

    public static final String MAIL_SERVICE_SITE = "MAIL_SERVICE_SITE";
    public static final String MAIL_USERNAME = "MAIL_USERNAME";
    public static final String MAIL_PASSWORD = "MAIL_PASSWORD";

    private MailSender() {
    }

    /**
     * 获取mail发送者单例
     * @return
     */
    public static MailSender getSender(){
        if (mailSender == null || mailSender.isUpdate()) {
            lock.lock();
            if (mailSender == null || mailSender.isUpdate()) {
                SettingService settingService = SpringUtils.getBean(SettingService.class);
                String serviceSite = settingService.getSetting(MAIL_SERVICE_SITE);
                String mailUsername = settingService.getSetting(MAIL_USERNAME);
                String mailPassword = settingService.getSetting(MAIL_PASSWORD);
                mailSender = new MailSender(serviceSite, mailUsername, mailPassword);
            }
            lock.unlock();
        }
        return mailSender;
    }

    /**
     * 获取是否更新
     * @return
     */
    private boolean isUpdate(){
        return isUpdate;
    }

    /**
     * 更新标志位, true 表明已经更新
     */
    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    /**
     * 初始化邮件发送器
     *
     * @param smtpHostName SMTP邮件服务器地址
     * @param username     发送邮件的用户名(地址)
     * @param password     发送邮件的密码
     */
    private MailSender(final String smtpHostName, final String username, final String password) {
        init(username, password, smtpHostName);
    }

    /**
     * 初始化邮件发送器
     *
     * @param username 发送邮件的用户名(地址)，并以此解析SMTP服务器地址
     * @param password 发送邮件的密码
     */
    private MailSender(final String username, final String password) {
        final String smtpHostName = "smtp." + username.split("@")[1];
        init(username, password, smtpHostName);
    }

    /**
     * 初始化
     *
     * @param username     发送邮件的用户名(地址)
     * @param password     密码
     * @param smtpHostName SMTP主机地址
     */
    private void init(String username, String password, String smtpHostName) {
        logger.info("连接信息: username=" + username + ";" + "password=" + password + ";" + "smtpHostName=" + smtpHostName);
        // 初始化props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtpHostName);
        props.put("mail.smtp.port", "25");
        //判断是否是qq邮箱，是则开启ssl加密否则不开启
        Integer beginIndex = smtpHostName.indexOf(".") + 1;
        Integer endIndex = smtpHostName.lastIndexOf(".");
        if (smtpHostName.substring(beginIndex, endIndex).equals("qq")) {
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                props.put("mail.smtp.ssl.enable", "true");
                props.put("mail.smtp.ssl.socketFactory", sf);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
        // 验证
        authenticator = new MailAuthenticator(username, password);
        // 创建session
        session = Session.getInstance(props, authenticator);
        session.setDebug(true);
    }

    /**
     * 发送邮件
     *
     * @param recipient 收件人邮箱地址
     * @param subject   邮件主题
     * @param content   邮件内容
     * @throws MessagingException
     */
    public void send(String recipient, String subject, Object content) throws MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content.toString(), "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }

}
