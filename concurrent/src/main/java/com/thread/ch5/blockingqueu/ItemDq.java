package com.thread.ch5.blockingqueu;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 存放到延时队列的元素，必须要实现Delayed接口
 *
 * 要包含元素数据和到期时间
 *
 * @param <T> 存放到延时队列的元素
 */
public class ItemDq<T> implements Delayed {

    //到期时间,单位ns,这里是到期的具体时刻
    private long activeTime;
    private T data;

    //传入的remainTime是ms，意思是多长时间后到期
    public ItemDq(long remainTime, T data) {
        super();
        this.activeTime = TimeUnit.NANOSECONDS.convert(remainTime, TimeUnit.MILLISECONDS)
                + System.nanoTime();
        this.data = data;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public T getData() {
        return data;
    }

    //返回当前元素的剩余时间,单位根据unit来定
    @Override
    public long getDelay(TimeUnit unit) {
        long remainTime = unit.convert(this.activeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        return remainTime;
    }

    //按照剩余时间排序
    @Override
    public int compareTo(Delayed o) {
        long flag = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return flag == 0 ? 0 : (flag > 0 ? 1 : 0);
    }
}
