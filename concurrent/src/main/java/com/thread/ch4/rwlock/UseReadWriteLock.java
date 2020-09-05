package com.thread.ch4.rwlock;

import com.thread.util.ThreadSleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReadWriteLock来设置读写商品信息
 */
public class UseReadWriteLock implements GoodsService{

    private GoodsInfo goodsInfo;

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock readLock = rwLock.readLock();
    private Lock writeLock = rwLock.writeLock();

    public UseReadWriteLock(GoodsInfo goodsInfo){
        this.goodsInfo = goodsInfo;
    }

    @Override
    public void setNumber(int number) {

        writeLock.lock();
        try{
            ThreadSleep.ms(5);
            goodsInfo.changeNumber(number);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public GoodsInfo getNumber() {

        readLock.lock();
        try{
            ThreadSleep.ms(5);
            return goodsInfo;
        } finally {
            readLock.unlock();
        }

    }
}
