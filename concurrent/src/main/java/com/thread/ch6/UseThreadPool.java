package com.thread.ch6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示预定义线程池的使用
 *
 * ThreadPoolExecutor   ExecutorService
 */
public class UseThreadPool {

    static class Worker implements Runnable{

        private String name;

        public Worker(String name){
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " is execute : " + name);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " is over!!!");
        }
    }

    static class CallWorker implements Callable<String> {

        private String name;

        public CallWorker(String name){
            this.name = name;
        }

        @Override
        public String call() throws Exception {

            System.out.println(Thread.currentThread().getName() + " is execute call: " + name);

            Thread.sleep(3000);

            System.out.println(name + " is over---");
            return "return value :" + name + "++";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorPool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());

//        ExecutorService executorPool = Executors.newCachedThreadPool();

        //分别创建5个线程
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker("Worker_" + i);
            executorPool.execute(worker);
        }
        for (int i = 0; i < 5; i++) {
            CallWorker callWorker = new CallWorker("CallWorker_" + i);
            Future<String> future = executorPool.submit(callWorker);
            System.out.println(future.get());
        }

        //等所有任务都执行结束后，关闭线程池
        executorPool.shutdown();

    }

}
