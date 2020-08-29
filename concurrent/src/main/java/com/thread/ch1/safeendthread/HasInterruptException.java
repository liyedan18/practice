package com.thread.ch1.safeendthread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 安全的终止线程--利用中断
 */
public class HasInterruptException {

    public static void main(String[] args) throws InterruptedException {
//        UseRunnable useRunnable = new EndRunnable().new UseRunnable();
        UseThread useThread = new UseThread("end-Thread");
        useThread.start();
        Thread.sleep(300);
        useThread.interrupt();  //中断标志位设为true
    }

    private static SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH;mm;ss");

    public static class UseThread extends Thread{
//    public class UseRunnable implements Runnable{

        public UseThread(String name){
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){ //Thread类提供的方法
//            while (!interrupted()){ //会将中断标志位重置为false, 则 flag 3 为false
                try {
                    System.out.println(threadName + dateFormat.format(new Date()));
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //查看中断标志位
                    System.out.println(threadName + " interrupt flag 1 is "
                            + isInterrupted() + " at "
                    + dateFormat.format(new Date()));
                    interrupt();
                    System.out.println(threadName + " interrupt flag 2 is "
                            + isInterrupted());
                    e.printStackTrace();
                }

                System.out.println(threadName);
            }
            System.out.println(threadName + " interrupt flag 3 is "
                    + isInterrupted());
        }

    }

}
