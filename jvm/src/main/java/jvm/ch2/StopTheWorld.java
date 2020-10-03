package jvm.ch2;

import jvm.util.ThreadSleep;

import java.util.LinkedList;
import java.util.List;

/**
 * 演示GC时的stopthe world现象
 *
 * 一个线程不停的添加数据，
 * 一个线程每隔100ms打印一次自己的执行时间（如果有stoptheworld现象，则这个线程打印的时间一定不是固定的100ms。
 * 会出现比100ms长的现象）
 *
 * Java8
 *
 * VM参数：
 *     -Xms300m -Xmx300m -XX:+PrintGCDetails -XX:+UseSerialGC
 */
public class StopTheWorld {

    public static void main(String[] args) {
        FillList fillList = new FillList();
        TimerThread timerThread = new TimerThread();
        fillList.start();
        timerThread.start();
    }

    /**
     * 不停的添加数据
     */
    static class FillList extends Thread {

        List<byte[]> list = new LinkedList<>();

        @Override
        public void run() {

            while (true) {

                if (list.size() * 512 / (1024 * 1024) > 1000) {
                    list.clear();
                    System.out.println("list is clear...");
                }

                for (int i = 0; i < 100; i++) {
                    list.add(new byte[512]);
                }
                ThreadSleep.sleepMs(1);
            }

        }
    }

    /**
     * 每100ms打印一次运行时间
     */
    static class TimerThread extends Thread {

        private static final long START_TIME = System.currentTimeMillis();

        @Override
        public void run() {
            for (; ; ) {
                long time = System.currentTimeMillis() - START_TIME;
                System.out.println(time / 1000 + "." + time % 1000);
                ThreadSleep.sleepMs(100);
            }
        }
    }


}
