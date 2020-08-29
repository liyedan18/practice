package com.thread.ch1.safeendthread;

/**
 * 安全的终止线程--利用中断
 */
public class EndThread {

    public static void main(String[] args) throws InterruptedException {
//        UseRunnable useRunnable = new EndRunnable().new UseRunnable();
        UseThread useThread = new UseThread("end-Thread");
        useThread.start();
        Thread.sleep(30);
        useThread.interrupt();  //中断标志位设为true
    }

    public static class UseThread extends Thread{
//    public class UseRunnable implements Runnable{

        public UseThread(String name){
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){ //Thread类提供的方法
                System.out.println(threadName + " is running...");
            }
            //查看中断标志位
            System.out.println(threadName + " interrupt flag 1 is "
            + isInterrupted());
            System.out.println(threadName + " interrupt flag 2 is "
                    + isInterrupted());
        }

    }

}
