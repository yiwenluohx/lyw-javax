package lyw.javax.queue;

import java.util.concurrent.Callable;

/**
 * @Author: luohx
 * @Description: 多线程模板
 * @Date: 2021/2/3 9:15
 */
public abstract class CallableTemplate<V> implements Callable<V> {
    /**
     * 前置处理，子类可以Override该方法
     */
    public void beforeProcess() {
        System.out.println("before process....");
    }

    /**
     * 处理业务逻辑的方法,需要子类去Override
     *
     * @return
     */
    public abstract V process() throws Exception;

    /**
     * 后置处理，子类可以Override该方法
     */
    public void afterProcess() {
        System.out.println("after process....");
    }

    @Override
    public V call() throws Exception {
        beforeProcess();
        V result = process();
        afterProcess();
        return result;
    }
}
