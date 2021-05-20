package lyw.javax.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: luohx
 * @Description: 创建线程池实现类
 * @Date: 2021/2/3 9:31
 */
public class ConcurrentThreadPool  implements IConcurrentThreadPool{

    private ThreadPoolExecutor threadPoolExecutor;

    private int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;

    private int maximumPoolSize = Runtime.getRuntime().availableProcessors() * 2;

    private RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();

    private long keepAliveTime = 60;

    @Override
    public void initConcurrentThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                20, keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(20), policy);
    }

    @Override
    public <V> V submit(CallableTemplate<V> task) throws InterruptedException, ExecutionException {
        Future<V> result = threadPoolExecutor.submit(task);
        return result.get();
    }

    @Override
    public <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        List<Future<V>> tasksResult = threadPoolExecutor.invokeAll(tasks);
        List<V> resultList = new ArrayList<V>();

        for (Future<V> future : tasksResult) {
            resultList.add(future.get());
        }
        return resultList;
    }
}
