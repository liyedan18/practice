package com.thread.ch1;

/**
 * 演示sleep()不会释放锁
 *
 */
public class SleepLock {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadSleep = new Thread(new ThreadSleep(), "Thread-sleep");
        Thread threadNotSleep = new Thread(new ThreadNotSleep(), "Thread-Not-sleep");
        threadSleep.start();
        //让sleep线程先获得锁
        Thread.sleep(1000);
        threadNotSleep.start();

    }

    static class ThreadSleep implements Runnable{

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
            System.out.println(name + " is running...");
            synchronized(lock){
                System.out.println(name + " already get lock");
                System.out.println(name + " is sleeping...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " sleep over...");
            }
            //执行到这里就已经释放锁了，其他线程就可以获取到锁

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is over!!!");

        }
    }

    static class ThreadNotSleep implements Runnable{

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
            System.out.println(name + " is running...");
            synchronized(lock){
                System.out.println(name + " already get lock");
                System.out.println(name + " doing work...");
            }
            System.out.println(name + " is over!!!");

        }
    }
}
