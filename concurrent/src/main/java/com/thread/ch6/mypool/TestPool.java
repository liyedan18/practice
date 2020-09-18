package com.thread.ch6.mypool;

import com.thread.util.ThreadSleep;

/**
 * 测试类
 *
 * 开启6个任务，每个任务睡眠3秒，10秒后，销毁线程池。
 */
public class TestPool {

    public static void main(String[] args) {

        MyThreadPool threadPool = new MyThreadPool();
        threadPool.execute(new Task("Thread-1"));
        threadPool.execute(new Task("Thread-2"));
        threadPool.execute(new Task("Thread-3"));
        threadPool.execute(new Task("Thread-4"));
        threadPool.execute(new Task("Thread-5"));
        threadPool.execute(new Task("Thread-6"));

        System.out.println("taskQueue size = " + threadPool.taskQueue.size());

        ThreadSleep.seconds(10);

        threadPool.destory();
        System.out.println("taskQueue size = " + threadPool.taskQueue.size());

    }

    //任务类
    static class Task implements Runnable{

        private String name;

        public Task(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is running...");
            ThreadSleep.seconds(3);
            System.out.println(name + " is over!!!");
        }

        //为了运行时打印任务名
        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
