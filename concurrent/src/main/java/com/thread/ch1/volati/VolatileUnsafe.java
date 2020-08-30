package com.thread.ch1.volati;

/**
 * volatile只能保证可见性，但不能保证操作的原子性。因此是不安全的。
 * 使用场景：
 * 只有一个写线程，多个读线程的
 */
public class VolatileUnsafe {

    public static void main(String[] args) {
        VolatiThread volatiThread = new VolatiThread();
        Thread thread1 = new Thread(volatiThread);
        Thread thread2 = new Thread(volatiThread);
        Thread thread3 = new Thread(volatiThread);
        Thread thread4 = new Thread(volatiThread);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


    private static class VolatiThread implements Runnable{

        private volatile int a = 0;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            a++;
            System.out.println(name + " a= " + a);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
            System.out.println(name + " a= " + a);
        }
    }
}
