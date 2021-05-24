package lyw.javax.test03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/5/21 0021 10:31
 */
public class Main {
    public static int m = 0;

    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                } finally {
                    lock.unlock();
                }
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();//等待所有线程运行结束。join是让线程顺序结束，方便打印最终的结果m
        }
        System.out.println(m);
    }
}
