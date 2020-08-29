package com.thread.ch1;

/**
 * synchronize中类锁和对象锁的区别
 */
public class SynClaAndInst {

    public static void main(String[] args) {
        //开启两个类锁线程: 两个都可以开启，但是同步方法是一个执行完后，另一个才能开始执行
        //互相争夺类字节码文件
/*
        SyncClass syncClass = new SyncClass();
        SyncClass syncClass2 = new SyncClass();
        syncClass.start();
        syncClass2.start();
*/

        //开启两个对象线程，注意要锁同一个对象，不能new两个对象
        //此时：两个线程要争夺锁对象，一个执行完释放锁后，另一个才能执行
        //与上面结果类似
/*        SynClaAndInst synObj = new SynClaAndInst();
        Thread syncInstance = new Thread(new SyncInst(synObj));
        Thread syncInstance2 = new Thread(new SyncInst2(synObj));
        syncInstance.start();
        syncInstance2.start();
        */
        //开启一个类锁，一个对象锁线程，则这两个锁互不影响，可以同时执行
        //也就是说，他们锁的不是同一个内容
        SynClaAndInst synClaAndInst = new SynClaAndInst();
        Thread syncObj = new Thread(new SyncInst(synClaAndInst));
        SyncClass syncClass = new SyncClass();
        syncClass.start();
        syncObj.start();

    }

    //使用类锁的线程
    public static class SyncClass extends Thread{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " SynClass thread is running...");
            try {
                synClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //使用对象锁的线程
    public static class SyncInst implements Runnable{

        private SynClaAndInst synClaAndInst;

        public SyncInst(SynClaAndInst synClaAndInst){
            this.synClaAndInst = synClaAndInst;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " SyncInst is running...");
            try {
                synClaAndInst.synInst();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //使用对象锁的线程
    public static class SyncInst2 implements Runnable{

        private SynClaAndInst synClaAndInst;

        public SyncInst2(SynClaAndInst synClaAndInst){
            this.synClaAndInst = synClaAndInst;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " SyncInst is running...");
            try {
                synClaAndInst.synInst2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //类锁，其实锁的是类的class文件
    private static synchronized void synClass() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " synClass is going...");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " synClass end.");
    }

    //对象锁
    private synchronized void synInst() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " synInst is going...");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " synInst end.");
    }

    //对象锁
    private synchronized void synInst2() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " synInst2 is going...");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " synInst2 end.");
    }

}
