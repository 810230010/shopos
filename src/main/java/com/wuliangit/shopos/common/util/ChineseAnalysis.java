package com.wuliangit.shopos.common.util;

import io.github.yizhiru.thulac4j.SegOnly;
import io.github.yizhiru.thulac4j.SegPos;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SegOnly分词速度更快，但是准确率较SegPos模式要低；
 * 而SegPos具有更高的准确率，内存占用更多、分词速度较慢
 * 框架github地址 https://github.com/yizhiru/thulac4j/wiki
 * <p>
 * 注：项目没有使用到SegPos模式故没有导入seg_pos.bin 文件，使用时请注意
 * <p>
 * Created by nilme on 2017/6/28.
 */
public class ChineseAnalysis {

    private static SegOnly segOnly;

    private static SegPos segPos;

    private static ReentrantLock lock = new ReentrantLock();

    /**
     * SegOnly模式，只分词没有词性标注
     *
     * @return
     */
    public static SegOnly getSegOnly() {
        if (segOnly == null) {
            lock.lock();
            if (segOnly == null) {
                InputStream inputStream = ChineseAnalysis.class.getClassLoader().getResourceAsStream("seg_only.bin");
                segOnly = new SegOnly(inputStream);
            }
            lock.unlock();
        }
        return segOnly;
    }


    /**
     * SegPos模式，分词兼有词性标注
     * 使用时请导入 seg_pos.bin 文件
     *
     * @return
     */
    public static SegPos getSegPos() {
        if (segPos == null) {
            lock.lock();
            if (segPos == null) {
                InputStream inputStream = ChineseAnalysis.class.getClassLoader().getResourceAsStream("seg_pos.bin");
                segPos = new SegPos(inputStream);
            }
            lock.unlock();
        }
        return segPos;
    }

    /**
     * 直接调用进行分词
     *
     * @param key 需要分词的字符串
     * @return
     */
    public static String segment(String key) {

        if (key == null || key.equals("")) {
            return null;
        }

        key = key.replaceAll("(，|\\s*|\r|\n)", "");

        List<String> list = ChineseAnalysis.getSegOnly().segment(key);

        StringBuilder sb = new StringBuilder();


        for (String s : list) {
            sb.append(s + " ");
        }

        return sb.toString();
    }

}
