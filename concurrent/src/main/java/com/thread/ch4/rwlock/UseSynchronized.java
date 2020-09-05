package com.thread.ch4.rwlock;

import com.thread.util.ThreadSleep;

/**
 * 使用synchronized来设置读写商品信息
 */
public class UseSynchronized implements GoodsService{

    private GoodsInfo goodsInfo;

    public UseSynchronized(GoodsInfo goodsInfo){
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized void setNumber(int number) {

        //模拟业务处理
        ThreadSleep.ms(5);

        goodsInfo.changeNumber(number);
    }

    @Override
    public synchronized GoodsInfo getNumber() {

        //模拟业务处理
        ThreadSleep.ms(5);

        return goodsInfo;
    }
}
