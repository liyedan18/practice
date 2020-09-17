package com.thread.ch5.blockingqueu;

import java.util.concurrent.DelayQueue;

/**
 * 循环获取延时订单，获取不到则阻塞
 */
public class GetOrder implements Runnable {

    private DelayQueue<ItemDq<Order>> delayQueue;

    public GetOrder(DelayQueue<ItemDq<Order>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {

        for (; ; ) {
            try {
                System.out.println("waiting for getting order from delayQueue...");
                ItemDq<Order> itemDq = delayQueue.take();
                Order order = itemDq.getData();
                System.out.println("get order from delayQueue: " + order.getOrderNum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
