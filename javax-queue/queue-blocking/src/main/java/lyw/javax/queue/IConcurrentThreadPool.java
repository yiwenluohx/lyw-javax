package lyw.javax.queue;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author: luohx
 * @Description: 线程池接口
 * @Date: 2021/2/3 9:12
 */
public interface IConcurrentThreadPool {

    /**
     * 初始化线程池
     */
    void initConcurrentThreadPool();

    /**
     * 提交单个任务
     *
     * @param task
     * @return
     */
    <V> V submit(CallableTemplate<V> task) throws InterruptedException,
            ExecutionException;

    /**
     * 提交多个任务
     *
     * @param tasks
     * @return
     */
    <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks)
            throws InterruptedException, ExecutionException;
}