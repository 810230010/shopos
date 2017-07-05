package com.wuliangit.shopos.common.jiguan;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 极光推送
 * Created by nilme on 2017/6/3.
 */
public class JPush {

    private static JPushClient client;
    private static ReentrantLock lock = new ReentrantLock();

    public static JPushClient getJPushClient() {
        if (client == null) {
            lock.lock();
            if (client == null) {
                client = new JPushClient("5879e6743ba697c4e03d9a22", "a5653b51f1997bc4b715fe64", null, ClientConfig.getInstance());
            }
            lock.unlock();
        }
        return client;
    }


    public static void main(String[] args) {
        PushPayload alert = PushPayload.newBuilder().setAudience(Audience.registrationId("171976fa8ab6d169330")).setPlatform(Platform.all()).setNotification(Notification.alert("ALERT")).build();

        PushPayload alert2 =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId("171976fa8ab6d169330"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert("ALERT")
                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                .setMessage(Message.content("MSG_CONTENT"))
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)
                        .build())
                .build();

        try {
            PushResult result = JPush.getJPushClient().sendPush(alert2);
            System.out.println(result.toString());
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

}
