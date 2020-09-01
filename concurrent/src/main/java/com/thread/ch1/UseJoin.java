package com.thread.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示join()的使用和作用
 *
 * 开启10个线程，线程0等主线程结束才执行
 * 线程1等线程0结束才执行
 * 2等1结束才执行。。。。
 */
public class UseJoin {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main thread is doing work...");
        List<Thread> threads = new ArrayList<>();
        Thread prev = Thread.currentThread();
        prev.setName("main");

        //创建线程
        for (int i = 0; i < 10; i++) {
            Thread tempThread = new Thread(new JoinThread(prev), String.valueOf(i));
            threads.add(tempThread);
            prev = tempThread;
        }
        for (Thread t : threads) {
            t.start();
        }

        System.out.println("main thread is sleeping...");
        Thread.sleep(2000);
        System.out.println("main thread is over!!!");

    }

    static class JoinThread implements Runnable {

        private Thread prevThread;

        public JoinThread(Thread prevThread) {
            this.prevThread = prevThread;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            String prevName = prevThread.getName();
            System.out.println(name + " is waiting..." + prevName);

            try {
                prevThread.join();
                //线程业务
                Thread.sleep(1000);
                System.out.println(name + " is over!!!");
            } catch (InterruptedException e) {
                //todo
                e.printStackTrace();
            }
        }
    }
}
