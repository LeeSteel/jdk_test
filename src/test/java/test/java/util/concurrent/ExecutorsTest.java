package test.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/8/16 13:55
 * @Copyright: Copyright (c) 2019
 */
public class ExecutorsTest {


    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    @Test
    public void newSingleThreadExecutorTest() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int tempIndex = i;
           pool.execute(() -> out.println(Thread.currentThread().getName() + "=>" + tempIndex));
            /**
             * 这样是修改不了当前执行线程名称的。
             * 原因：1、线程池只执行了线程的run方法，不启动对应的线程
             *      2、线程池线程名称要通过初始化线程池时，传入自定义ThreadFactory实现
             * pool.execute(new Thread(() -> out.println(Thread.currentThread().getName() + "=>" + tempIndex),
             *      "pool-1-thread-" + tempIndex));
             */
        }
        pool.shutdown();
    }
}
