package lyw.javax.queue;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author: luohx
 * @Description: 线程任务框架
 * @Date: 2021/2/3 10:20
 */
@Component
public class CallableTaskFrameWork implements ICallableTaskFrameWork {
    private IConcurrentThreadPool concurrentThreadPool = new ConcurrentThreadPool();

    @Override
    public <V> V submit(CallableTemplate<V> task) throws InterruptedException, ExecutionException {
        concurrentThreadPool.initConcurrentThreadPool();
        return concurrentThreadPool.submit(task);
    }

    @Override
    public <V> List<V> submitsAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        concurrentThreadPool.initConcurrentThreadPool();
        return concurrentThreadPool.invokeAll(tasks);
    }
}
