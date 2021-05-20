package lyw.javax.queue;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author: luohx
 * @Description: 线程任务框架接口
 * @Date: 2021/2/3 9:57
 */
public interface ICallableTaskFrameWork {
    <V> V submit(CallableTemplate<V> task) throws InterruptedException,
            ExecutionException;

    <V> List<V> submitsAll(List<? extends CallableTemplate<V>> tasks)
            throws InterruptedException, ExecutionException;
}