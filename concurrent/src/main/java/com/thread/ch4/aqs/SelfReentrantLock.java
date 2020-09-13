package com.thread.ch4.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * aqs练习：
 * 实现一个自己的ReentrantLock
 * 独占式获取锁版本，且是非公平锁
 */
public class SelfReentrantLock implements Lock {

    //继承模板类——实现流程方法
    //state - 1 获取到锁   0  未获取到锁
    private static class Sync extends AbstractQueuedSynchronizer{

        //尝试cas获取锁
        @Override
        protected boolean tryAcquire(int arg){
            if (compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }

        //先判断当前锁状态是否是正确的，也就是>0。然后再释放锁
        //这里不用cas，独占式释放锁时，只有自己拿到了锁状态。释放时不存在竞争
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0){
                throw new UnsupportedOperationException();
            }

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //是否独占、是否占用
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    private final Sync sync;

    public SelfReentrantLock(){
        sync = new Sync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        //释放1个锁，之后会唤醒下个节点（利用lock.unPark）
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

}
