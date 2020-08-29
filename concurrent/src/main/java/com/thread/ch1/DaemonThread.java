package com.thread.ch1;

/**
 * 守护线程的结束和finally语句块是否执行
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        ExtThread thread = new ExtThread();
        //注意设置true和false的运行结果区别
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(20);
        thread.interrupt();

    }

    private static class ExtThread extends Thread{
        @Override
        public void run() {
            try {

                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " is running...");
                }
                System.out.println(Thread.currentThread().getName() + " interrupt flag is "
                        + isInterrupted());

            } finally {
                System.out.println("finally...");
            }
        }
    }

}

