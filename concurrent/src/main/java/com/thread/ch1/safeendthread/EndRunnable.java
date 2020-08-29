package com.thread.ch1.safeendthread;

/**
 * 安全的终止线程--利用中断
 */
public class EndRunnable {

    public static void main(String[] args) throws InterruptedException {
//        UseRunnable useRunnable = new EndRunnable().new UseRunnable();
        UseRunnable useRunnable = new UseRunnable();
        Thread threadRunnable = new Thread(useRunnable);
        threadRunnable.start();
        Thread.sleep(30);
        threadRunnable.interrupt();  //中断标志位设为true
    }

    public static class UseRunnable implements Runnable{
//    public class UseRunnable implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(threadName + " is running...");
            }
            //查看中断标志位
            System.out.println(threadName + " interrupt flag is "
            + Thread.currentThread().isInterrupted());
        }

    }

}
