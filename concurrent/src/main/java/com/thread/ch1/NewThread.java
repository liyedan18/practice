package com.thread.ch1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 新建线程的3种方式
 */
public class NewThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExtThread extThread = new ExtThread();
        extThread.start();

        ThreadRunnable threadRunnable = new ThreadRunnable();
        new Thread(threadRunnable).start();

        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask<String> futureTask = new FutureTask<>(threadCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}

/**
 * 继承Thread类
 */
class ExtThread extends Thread{
    @Override
    public void run(){
        System.out.println("I am extends Thread.");
    }
}

/**
 * 实现Runnable接口
 */
class ThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("I am implements Runnable.");
    }
}

/**
 * 实现Callable接口，并定义返回值类型<>String</>
 * 重写call方法
 * 会抛出异常
 */
class ThreadCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("I am implements Callable<T>");
        return "callresult";
    }
}

