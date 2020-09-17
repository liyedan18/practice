package com.thread.ch5.blockingqueu;

import java.util.concurrent.DelayQueue;

/**
 * 测试客户端
 */
public class Client {

    private static final int SLEEP_TIME = 500;

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<ItemDq<Order>> delayQueue = new DelayQueue<>();

        new Thread(new PutOrder(delayQueue)).start();
        new Thread(new GetOrder(delayQueue)).start();

        //每隔500ms，打印一次
        for (int i = 0; i < 30; i++) {
            System.out.println("time:" + i * SLEEP_TIME);
            Thread.sleep(SLEEP_TIME);
        }
    }
}
