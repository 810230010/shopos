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
                client = new JMessageClient("2a4c503ab7722d0af84f7bf2", "0b62432b3f499dc53329b041");
            }
            lock.unlock();
        }
        return client;
    }

}
