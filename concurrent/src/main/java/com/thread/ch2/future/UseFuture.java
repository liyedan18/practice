package com.thread.ch2.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable/Future/FutureTask的使用
 * 线程可以被取消执行
 *
 * 异步计算从0加到10000
 */
public class UseFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new Compute());
        new Thread(futureTask).start();

        //随机决定是否取消任务执行
        Random random = new Random();
        if (random.nextBoolean()) {
            futureTask.cancel(true);
            System.out.println("compute is canceled!!!");
        } else {
            System.out.println("result = " + futureTask.get());
        }

    }

    static class Compute implements Callable<Integer> {

        @Override
        public Integer call() {

            System.out.println("Compute start to compute...");

            int total = 0;
            for (int i = 0; i < 10000; i++) {
                total += i;
            }

            System.out.println("Compute compute over!!!");

            return total;
        }
    }
}
