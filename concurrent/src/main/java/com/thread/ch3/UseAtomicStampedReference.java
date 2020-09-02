package com.thread.ch3;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带有版本戳的引用类型原子操作类
 *
 * 起两个线程，一个有正确的版本号，一个有错误的版本号
 * 两个线程都修改数据，只有正确版本号的线程可以修改成功
 *
 */
public class UseAtomicStampedReference {

    private static AtomicStampedReference<String> asRef =
            new AtomicStampedReference<>("cake", 1);

    public static void main(String[] args) throws InterruptedException {

        Thread rightStamp = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("rightStamp is setting reference...");
                boolean isSuccess = asRef.compareAndSet("cake", "apple", 1, 2);
                System.out.println("Success? " + isSuccess);
                System.out.println(asRef.getReference());
                System.out.println(asRef.getStamp());

            }
        });

        Thread wrongStamp = new Thread(() -> {

            System.out.println("wrongStamp is setting reference...");
            boolean isSuccess = asRef.compareAndSet("cake", "banana", 0, 3);
            System.out.println("Success? " + isSuccess);
            System.out.println(asRef.getReference());
            System.out.println(asRef.getStamp());

        });

        rightStamp.start();

        Thread.sleep(3000);

        wrongStamp.start();

    }
}
