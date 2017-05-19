package com.wuliangit.shopos.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : nilme
 * @ClassName: OrderUtil
 * @Description: 订单号生成工具，生成非重复订单号，理论上限1毫秒1000个，可扩展
 */
public class OrderUtil {
    /**
     * 锁对象，可以为任意对象
     */
    private static Object lockObj = "lockerOrder";
    /**
     * 订单号生成计数器
     */
    private static long orderNumCount = 0L;
    /**
     * 每毫秒生成订单号数量最大值
     */
    private static int maxPerMSECSize = 1000;

    /**
     * 生成非重复订单号，理论上限1毫秒1000个，可扩展
     */
    public static String makeOrderId() {
        try {
            // 最终生成的订单号
            String finOrderNum = null;
            synchronized (lockObj) {
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒
                long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
                if (orderNumCount >= maxPerMSECSize) {
                    orderNumCount = 0L;
                }
                //组装订单号
                String countStr = maxPerMSECSize + orderNumCount + "";
                finOrderNum = nowLong + countStr.substring(1);
                orderNumCount++;
                return finOrderNum;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // 测试多线程调用订单号生成工具
        try {
            for (int i = 0; i < 200; i++) {
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        String s = OrderUtil.makeOrderId();
                        System.out.println(s + ":a");
                    }
                });
                t1.start();

                Thread t2 = new Thread(new Runnable() {
                    public void run() {
                        String s = OrderUtil.makeOrderId();
                        System.out.println(s + ":b");
                    }
                });
                t2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}