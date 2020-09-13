package com.thread.ch4.aqs;

import com.thread.util.ThreadSleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动10个线程来测试SelfReentrantLock
 * 线程只休眠加打印线程名称
 *
 * 注意打印结果的规律，是按照一定顺序循环的。
 * 独占锁，每次只会有一个线程拿到锁在运行。
 *
 */
public class TestSelfLock {

    public static void main(String[] args) {
        TestSelfLock selfLock = new TestSelfLock();
        selfLock.test();
    }

    public void test(){

        final Lock lock = new SelfReentrantLock();
        //对比
//        final Lock lock = new ReentrantLock();

        class Worker extends Thread{

            @Override
            public void run() {

                while (true) {
                    lock.lock();
                    try {
                        ThreadSleep.seconds(1);
                        System.out.println(Thread.currentThread().getName());
                        ThreadSleep.seconds(1);
                    } finally {
                        lock.unlock();
                    }
                    ThreadSleep.seconds(1);
                }

            }
        }

        for (int i = 0; i < 10; i++) {
            Thread thread = new Worker();
            //目的：test线程执行完后，让其他10个线程也退出
            thread.setDaemon(true);
            thread.start();
        }

        //让当前线程不会立即结束
        for (int i = 0; i < 10; i++) {
            System.out.println("==================");
            ThreadSleep.seconds(10);
        }

    }
}
