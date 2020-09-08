package com.thread.ch2.tools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * 演示CyclicBarrier的使用
 * 开启4个计算线程，把各自的结果保存起来。
 * 由最终的汇总线程进行计算总结过后，其他线程再继续执行。
 *
 *
 * CyclicBarrier与CountDownLatch的区别：
 *
 * 1、
 * CyclicBarrier的屏障开启是由工作线程自己决定的，没有类似countDown()的方法。
 * await()的个数等于设置的屏障数时，线程自动开始执行。
 *
 * CountDownLatch的启动是由第三方决定。
 *
 * 2、cyclicbarrier可以重置
 * CountDownLatch不能重置
 */
public class UseCyclicBarrier {

    //另一种方式不带任务线程 = new CyclicBarrier(4);
    //只有在任务线程执行结束后，屏障才会开启
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Summary());

    //保存计算结果
    private static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            new Thread(new Compute()).start();
        }

    }

    static class Compute implements Runnable {

        @Override
        public void run() {

            //将线程id作为计算结果
            long id = Thread.currentThread().getId();
            System.out.println("Thread-" + id + " is computing...");
            map.put(String.valueOf(id), id);

            //增加随机睡眠
            Random random = new Random();
            if (random.nextBoolean()) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread-" + id + " is doing work...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //等待其他线程
            System.out.println("Thread-" + id + " compute over and is awating...");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("Thread-" + id + " ended!!!");

        }
    }

    //汇总结果
    static class Summary implements Runnable {

        @Override
        public void run() {

            System.out.println("Summary Thread is computing...");
            long sum = map.values().stream().mapToLong(Long::valueOf).sum();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Summary Thread get result = " + sum);

        }
    }
}
