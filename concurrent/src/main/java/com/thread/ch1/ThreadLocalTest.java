package com.thread.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreadLocal的使用
 *
 * 开启3个线程，查看i的变化.i值互不影响。
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threadList.add(new Thread(new ThreadLocalThread(i)));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    //threadLocal变量初始化
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
        @Override
        public Integer initialValue(){
            return 1;
        }
    };


    static class ThreadLocalThread implements Runnable{

        private int id;

        public ThreadLocalThread(int id){
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " :start");
            int i = threadLocal.get();
            i = i + id;
            threadLocal.set(i);
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }
    }

}

