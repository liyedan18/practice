package com.thread.ch5.blockingqueu;

/**
 * 订单信息实体类
 */
public class Order {

    private String orderNum;
    private double money;

    public Order(String orderNum, double money){
        this.money = money;
        this.orderNum = orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public double getMoney() {
        return money;
    }
}
