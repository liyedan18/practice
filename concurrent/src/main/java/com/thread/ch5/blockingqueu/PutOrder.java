package com.thread.ch5.blockingqueu;

import java.util.concurrent.DelayQueue;

/**
 * （生成订单并）将订单放入延时队列——需要内部维护延时队列
 *
 * 生成2个订单，一个5秒后到期，一个10秒后到期。然后存入队列。随后即结束
 */
public class PutOrder implements Runnable{

    private DelayQueue<ItemDq<Order>> delayQueue;

    public PutOrder(DelayQueue<ItemDq<Order>> delayQueue){
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {

        //5s到期订单
        Order order5 = new Order("111", 100);
        ItemDq<Order> itemTb = new ItemDq<>(5000, order5);
        delayQueue.offer(itemTb);
        System.out.println("5s后订单到期：" + order5.getOrderNum());

        //10s到期订单
        Order order10 = new Order("222", 200);
        ItemDq<Order> itemJD = new ItemDq<>(10000, order10);
        delayQueue.offer(itemJD);
        System.out.println("10s后订单到期：" + order10.getOrderNum());

    }
}
