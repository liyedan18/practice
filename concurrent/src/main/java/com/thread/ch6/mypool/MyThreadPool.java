package com.thread.ch6.mypool;

import com.thread.util.ThreadSleep;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 自定义实现一个线程池，用阻塞队列
 *
 * 阻塞队列用于存放线程任务
 * 应该包括默认运行线程数、队列最大任务数。
 * 包括execute()、destory()
 * 还包括工作线程，即从队列获取线程任务并运行。工作线程也可以被中止。
 */
public class MyThreadPool {

    //默认运行线程数
    private static int coreSize = 3;
    //队列最大任务数
    private static int maxTaskNum = 100;

    //保存工作线程
    private WorkThread[] workThreads;

    protected BlockingQueue<Runnable> taskQueue;

    public MyThreadPool(){
        taskQueue = new ArrayBlockingQueue<>(maxTaskNum);
        workThreads = new WorkThread[coreSize];
        for (int i = 0; i < coreSize; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    //执行也就是将任务提交给队列
    //任务的实际执行由线程池中工作线程管理
    public void execute(Runnable task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //销毁线程池，并清空队列
    public void destory(){
        System.out.println("ready to close pool...");
        for (int i = 0; i < coreSize; i++) {
            workThreads[i].stopWork();
            workThreads[i] = null;  //help gc
        }

        taskQueue.clear();
    }

    //工作线程
    //不断从队列中获取任务并运行
    private class WorkThread extends Thread {

        @Override
        public void run() {
            Runnable runnableTask = null;

            try {
                while (!isInterrupted()) {
                    runnableTask = taskQueue.take();
                    if (runnableTask != null){
                        System.out.println(getId() + " is going to exec :" + runnableTask);
                        //直接调用线程的run()执行
                        runnableTask.run();
                    }

                    //help GC
                    runnableTask = null;
                }
            } catch (InterruptedException e) {
                System.out.println(getId() + " is interrupted!!" + isInterrupted());
            }
        }

        //利用中断停止任务执行
        public void stopWork(){
            interrupt();
            System.out.println(getId() + " is interrupted!!===" + isInterrupted());
        }
    }


}
