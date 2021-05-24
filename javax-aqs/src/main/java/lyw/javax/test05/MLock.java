package lyw.javax.test05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/5/21 0021 11:30
 */
public class MLock implements Lock {

    private volatile int i = 0;

    @Override
    public void lock() {
        synchronized (this) {
            while (i != 0) { //已经有线程占用
                try {
                    this.wait();//阻塞，也可以用CAS替代
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
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
            this.notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
