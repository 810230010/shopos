package com.wuliangit.shopos.thulac4j;

import io.github.yizhiru.thulac4j.SegOnly;
import io.github.yizhiru.thulac4j.SegPos;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by nilme on 2017/6/28.
 */
public class Thulac4jTest {


    public static void main(String[] args) throws FileNotFoundException {

        String s = Thulac4jTest.class.getClassLoader().toString();

        InputStream in = Thulac4jTest.class.getClassLoader().getResourceAsStream("seg_only.bin");

        long startTime1 = System.currentTimeMillis();
        SegOnly seg = new SegOnly(in);
        long endTime1 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");


        // SegOnly mode
        String sentence = "滔滔的流水向着波士顿湾无声逝去";
//        SegOnly seg = new SegOnly("/Users/nilme/workspace/waibao/shopos/src/test/java/com/wuliangit/shopos/thulac4j/seg_only.bin");

        long startTime = System.currentTimeMillis();    //获取开始时间
        System.out.println(seg.segment(sentence));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }
}
