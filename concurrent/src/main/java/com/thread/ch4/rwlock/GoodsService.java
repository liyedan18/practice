package com.thread.ch4.rwlock;

public interface GoodsService {
    //设置商品数量
    void setNumber(int number);

    //获取商品信息
    GoodsInfo getNumber();
}
