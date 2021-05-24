package lyw.javax.test06;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/5/21 0021 13:46
 */
public class Sync extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        if (compareAndSetState(0, 1)) {
            //设置排他（互斥）线程
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        //有问题
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        //有问题
        return getState() == 1;
    }
}
