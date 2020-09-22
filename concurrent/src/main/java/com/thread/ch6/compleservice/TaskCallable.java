package com.thread.ch6.compleservice;


import com.thread.util.ThreadSleep;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 任务，随机休眠10s以内
 */
public class TaskCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        int sleepMs = new Random().nextInt(5000);
        ThreadSleep.ms(sleepMs);

        return sleepMs;
    }
}
