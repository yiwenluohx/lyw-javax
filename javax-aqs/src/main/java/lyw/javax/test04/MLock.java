package lyw.javax.test04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/5/21 0021 11:02
 */
public class MLock implements Lock {

    private volatile int i = 0;

    @Override
    public void lock() {
        synchronized (this) {
            i = 1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            i = 0;
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
