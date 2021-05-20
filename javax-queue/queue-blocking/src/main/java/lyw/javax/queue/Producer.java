package lyw.javax.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: luohx
 * @Description: 生产者
 * @Date: 2021/2/3 10:23
 */
@Slf4j
public class Producer implements Runnable{

    private BlockingQueue<String> queue;
    private String actionDto;

    public Producer(BlockingQueue<String> queue, String actionDto) {
        this.queue = queue;
        this.actionDto = actionDto;
    }

    @Override
    public void run() {
        try {
            queue.put(actionDto);
            log.info("生产的消息：" + actionDto);
        } catch (InterruptedException e) {
            log.error("消息入队失败：actionDto=" + actionDto);
        }
    }
}
