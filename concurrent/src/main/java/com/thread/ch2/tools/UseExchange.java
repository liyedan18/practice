package com.thread.ch2.tools;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 * exchanger的使用和作用
 *
 * 用于两个线程交换数据
 * 有且只有两个线程
 */
public class UseExchange {

    private static Exchanger<Set<String>> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        new Thread(() -> {

            Set<String> set = new HashSet<>();
            set.add("aaa");
            set.add("bbb");
            set.add("ccc");
            String name = Thread.currentThread().getName();
            System.out.println(name +" berofe exchange: setA = " + set.toString());

            try {
                Thread.sleep(5000);
                //和另一个线程进行数据交换
                set = exchanger.exchange(set);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +" after exchange: setA = " + set.toString());

        }).start();

        new Thread(() -> {

            Set<String> set = new HashSet<>();
            set.add("xxx");
            set.add("yyy");
            set.add("zzz");
            String name = Thread.currentThread().getName();
            System.out.println(name +" berofe exchange: setB = " + set.toString());

            try {
                //这是阻塞方法，会一直等待另一个线程调用exchange();
                set = exchanger.exchange(set);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +" after exchange: setB = " + set.toString());

        }).start();

        //多一个线程，则会有一个线程不能完成数据交换而阻塞在exchange()处
/*
        new Thread(() -> {

            Set<String> set = new HashSet<>();
            set.add("UUU");
            set.add("MMM");
            set.add("GGG");
            String name = Thread.currentThread().getName();
            System.out.println(name +" berofe exchange: setC = " + set.toString());

            try {
                set = exchanger.exchange(set);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +" after exchange: setD = " + set.toString());
        }).start();
*/


    }

}
