package com.thread.ch4.conditionlock;

import com.thread.util.ThreadSleep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示Condition和Lock的结合使用
 *
 * 2个生产者 —— 生产者不断生产数据，(10个)满了以后，等待消费者消费完，然后再生产。
 *        生产者1生产1-20；生产者2生产21-40；
 * 1个消费者 —— 消费者等数据满了后，消费数据（10个），数据池空了则等待。
 */
public class AppClient {

    private static List<Integer> dataList = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition consumerCondition = lock.newCondition();
    private static Condition producerCondition = lock.newCondition();

    public static void main(String[] args) {

        //生产者1
        Producer producer1 = new Producer(1);
        //生产者2，数字用于生产不同的数据
        Producer producer2 = new Producer(2);

        new Thread(producer1).start();
        new Thread(producer2).start();

        Consumer consumer = new Consumer();
        new Thread(consumer).start();

    }

    static class Consumer implements Runnable{

        @Override
        public void run() {

            lock.lock();
            System.out.println("consumer is consuming data...");

            try{

                for (int i = 0; i < 40; i++) {
                    //数据为空，通知生产者生产数据
                    if (dataList.size() <= 0) {

                        System.out.println("data is empty!!!");
                        producerCondition.signalAll();

                        try {
                            System.out.println("Consumer is waiting for producing ...");
                            consumerCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    ThreadSleep.ms(100);
                    Integer data = dataList.remove(0);
                    System.out.println("data-" + data + " is comsumed!!!");

                }

            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable{

        private int num;

        public Producer(int num){
            this.num = num;
        }

        @Override
        public void run() {

            lock.lock();
            System.out.println("Producer-" + num + " is producing data ===");

            try{

                for (int i = (num - 1) * 20; i < num * 20; i++) {

                    //数据满了，通知消费者消费数据
                    //这里两个生产者线程在抢夺，有并发问题
                    if (dataList.size() >= 10 ) {

                        System.out.println("data is full ===");
                        //只有一个消费者
                        consumerCondition.signal();

                        try {
                            System.out.println("Producer-" + num + " is waiting for consuming ===...");
                            producerCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    dataList.add(i);
                    ThreadSleep.ms(50);
                    System.out.println("data+" + i + " is produced===");
                    System.out.println(dataList.size());

                }

            } finally {
                lock.unlock();
            }
        }
    }
}
