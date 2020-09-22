package com.thread.ch6.compleservice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示CompletionService的应用
 * 作用：先执行完的任务可以先返回
 *
 * 实现开启16个带返回值的线程（用线程池），每个线程随机休眠一定时间，获取休眠时间返回结果，并统计休眠总时间。
 *
 * 以上任务，方式一、自己实现
 * 方式二、使用CompletionService
 *
 * 自己实现：
 * 用队列存储线程线程任务，然后依次获取任务结果，最后再统计休眠时间。
 *
 * 自己实现的弊端：
 * 获取任务结果时，必须要等待当前任务执行完成后，才能获取下一个任务的结果。类似于穿行。
 *
 */
public class CompleteTest {

    private final int TOTAL_TASK = Runtime.getRuntime().availableProcessors();
    private final int POOL_SIZE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompleteTest test = new CompleteTest();
        test.testByMyQueue();
        test.testByComplete();
    }

    //自己用队列实现
    public void testByMyQueue() throws ExecutionException, InterruptedException {
        long timeBegin = System.currentTimeMillis();
        //统计所有任务总时长
        AtomicInteger sleepTime = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        //存放执行任务
        BlockingQueue<Future<Integer>> queue = new LinkedBlockingQueue<>();

        //开启任务并添加到结果队列
        for (int i = 0; i < TOTAL_TASK; i++) {
            Future<Integer> task = executor.submit(new com.leetcode.lambda.compleservice.TaskCallable());
            queue.add(task);
        }

        //获取任务结果
        for (int i = 0; i < TOTAL_TASK; i++) {
            int time = queue.take().get();
            System.out.println("sleep time : " + time);
            sleepTime.addAndGet(time);
        }

        //关闭线程池
        executor.shutdown();
        System.out.println("------testByMyQueue spend time:" + (System.currentTimeMillis() - timeBegin));
        System.out.println("------testByMyQueue sleep time:" + sleepTime.get());

    }


    //用CompleteService
    public void testByComplete() throws ExecutionException, InterruptedException {
        long timeBegin = System.currentTimeMillis();
        //统计所有任务总时长
        AtomicInteger sleepTime = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        CompletionService<Integer> completion = new ExecutorCompletionService(executor);

        //任务添加到complete
        for (int i = 0; i < TOTAL_TASK; i++) {
            completion.submit(new com.leetcode.lambda.compleservice.TaskCallable());
        }

        //获取任务结果
        for (int i = 0; i < TOTAL_TASK; i++) {
            int time = completion.take().get();
            System.out.println("sleep time : " + time);
            sleepTime.addAndGet(time);
        }

        //关闭线程池
        executor.shutdown();
        System.out.println("------testByComplete spend time:" + (System.currentTimeMillis() - timeBegin));
        System.out.println("------testByComplete sleep time:" + sleepTime.get());
    }

}
