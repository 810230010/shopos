package com.wuliangit.shopos.common.im;

import cn.jmessage.api.JMessageClient;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2017/6/3.
 */
public class JpushIM {

    private static JMessageClient client;
    private static ReentrantLock lock = new ReentrantLock();

    public static JMessageClient getClient() {
        if (client == null) {
            lock.lock();
            if (client == null) {
                client = new JMessageClient("a5653b51f1997bc4b715fe64", "5879e6743ba697c4e03d9a22");
            }
            lock.unlock();
        }
        return client;
    }

}
