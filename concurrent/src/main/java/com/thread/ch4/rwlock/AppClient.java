package com.thread.ch4.rwlock;

import com.thread.util.ThreadSleep;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 演示ReadWriteLock与synchronized在同时读写的情况下
 * 效率的差别
 *
 * 30个读线程（每个线程读取100次）
 * 和3个写线程（每个线程设置10次，每次间隔50ms）
 *
 * 同时开启所有线程
 *
 * 打印每次读写操作各需要多长时间
 */
public class AppClient {

    private static int writeThreadNum = 3;
    //读写线程的比例
    private static int ratio = 10;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {

        GoodsInfo goodsInfo = new GoodsInfo("bike", 10000, 1000);

        //UseSynchronized
//        GoodsService goodsService = new UseSynchronized(goodsInfo);
        //UseReadWriteLock
        GoodsService goodsService = new UseReadWriteLock(goodsInfo);

        for (int i = 0; i < writeThreadNum; i++) {
            for (int j = 0; j < ratio; j++) {
                Thread readThread = new Thread(new ReadThread(goodsService));
                readThread.start();
            }
            Thread writeThread = new Thread(new WriteThread(goodsService));
            writeThread.start();
        }

        //让所有线程准备好
        ThreadSleep.seconds(1);

        latch.countDown();

    }

    static class ReadThread implements Runnable{

        private GoodsService goodsService;

        public ReadThread(GoodsService goodsService){
            this.goodsService = goodsService;
        }

        @Override
        public void run() {

            //等待所有线程统一执行
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String name = Thread.currentThread().getName();
            long before = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                goodsService.getNumber();
            }
            System.out.println(name + " 读商品数据耗时：" + (System.currentTimeMillis() - before));

        }
    }

    static class WriteThread implements Runnable{

        private GoodsService goodsService;

        public WriteThread(GoodsService goodsService){
            this.goodsService = goodsService;
        }

        @Override
        public void run() {

            //等待所有线程统一执行
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String name = Thread.currentThread().getName();
            long before = System.currentTimeMillis();
            Random random = new Random(100);
            for (int i = 0; i < 10; i++) {
                ThreadSleep.ms(50);
                goodsService.setNumber(random.nextInt());
            }
            System.out.println(name + " ======写商品数据耗时：" + (System.currentTimeMillis() - before));

        }
    }

}
