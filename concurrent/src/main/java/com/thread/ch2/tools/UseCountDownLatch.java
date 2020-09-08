package com.thread.ch2.tools;

import java.util.concurrent.CountDownLatch;

/**
 * 演示CountDownLatch的使用
 *
 * 3个业务线程等待1个初始化线程完成后，才能开始工作。
 * 4个线程，5个扣减计数
 *
 * 扣减计数一结束，等待在latch.await();处的线程就开始执行了。
 */
public class UseCountDownLatch {

    private static CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("MainThread is initial...");
        latch.countDown();
        for (int i = 0; i < 3; i++) {
            new Thread(new BusinessThread(), "BusinessThread" + i).start();
        }

        Thread.sleep(2000);

        new Thread(new InitThread()).start();

    }

    static class InitThread implements Runnable{

        @Override
        public void run() {

            System.out.println("InitThread is initial...1");
            latch.countDown();
            System.out.println("InitThread is initial...2");
            latch.countDown();
            System.out.println("InitThread is initial...3");
            latch.countDown();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("InitThread is initial...4");
            //下面这步执行完后，业务线程就开始执行了。而不是等待初始化线程全部执行结束。
            latch.countDown();
            System.out.println("InitThread initial over!!!");
        }
    }

    static class BusinessThread implements Runnable{

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting to do work...");

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " has completed work!!!");

        }
    }
}
