package com.thread.ch6.schd;


import com.thread.util.ThreadSleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试定时周期工作线程在3种情况下的工作状态
 *
 * 正常执行没有异常
 * 抛出异常没有被捕捉
 * 抛出异常被捕捉
 *
 * 注意schedule/scheduleWithFixedDelay/scheduleAtFixedDelay区别
 */
public class UseScheduleThreadPool {

    private static final int NORMAL = 0;
    private static final int EXCEPTION_WITHOUT_CATCH = 1;
    private static final int EXCEPTION_CATCH = 2;

    private static SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        System.out.println("start time:" + dateFormat.format(new Date()));

        //只执行一次
//        executor.schedule(new ScheduleWorker(NORMAL), 2, TimeUnit.SECONDS);

        //固定周期执行，初始延迟2s，周期为3s
        //异常被捕捉，可以一直正常执行下去
//        executor.scheduleAtFixedRate(new ScheduleWorker(EXCEPTION_CATCH), 2,3, TimeUnit.SECONDS);

        //固定周期执行，初始延迟2s，周期为3s，这里的周期是在上一个任务执行结束后，才开始计算3s周期
        executor.scheduleWithFixedDelay(new ScheduleWorker(EXCEPTION_CATCH), 2, 3, TimeUnit.SECONDS);

        //固定周期执行，初始延迟2s，周期为3s
        //异常没有被捕捉，程序会卡住，不能一直执行
//        executor.scheduleAtFixedRate(new ScheduleWorker(EXCEPTION_WITHOUT_CATCH), 2,3, TimeUnit.SECONDS);

//        executor.shutdown();
    }

    static class ScheduleWorker implements Runnable{

        private int state = 0;

        public ScheduleWorker(int state){
            this.state = state;
        }

        @Override
        public void run() {

            if (state == NORMAL){
                System.out.println("NORMAL is running..." + dateFormat.format(new Date()));
                ThreadSleep.seconds(2);
            } else if (state == EXCEPTION_WITHOUT_CATCH){
                System.out.println("EXCEPTION_WITHOUT_CATCH is running..." + dateFormat.format(new Date()));
                ThreadSleep.seconds(2);
                throw new RuntimeException("exception happen !!!");
            } else {
                try {
                    System.out.println("EXCEPTION_CATCH is running..." + dateFormat.format(new Date()));
                    ThreadSleep.seconds(2);
                    throw new RuntimeException("exception happen !!!");
                } catch (Exception e){
                    System.out.println("exception has been catched !!!");
                }
            }

        }
    }
}
