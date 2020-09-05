package com.thread.util;

/**
 * 线程睡眠工具类，为了不在使用时处理异常
 */
public class ThreadSleep {

    //睡眠second秒
    public static void seconds(int second){
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //睡眠毫秒
    public static void ms(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
