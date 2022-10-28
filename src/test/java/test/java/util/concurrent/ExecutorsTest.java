package test.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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
     * 创建一个周期性执行的线程池，指定核心线程数
     *  执行器选择 ScheduledExecutorService
     */
    @Test
    public void newScheduledThreadPoolTest() throws InterruptedException, ExecutionException {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        //入队列
        for (int i = 0; i < 9; i++) {
            queue.add("task-" + i);
        }
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < queue.size(); i++) {
            // 3秒执行1次
            ScheduledFuture<String> scheduledFuture = executorService.schedule(() -> {
                String value =   queue.poll();
                if (value != "" && null != value) {
                    System.out.println("时间:" + sdf.format(new Date())+"线程" + Thread.currentThread().getName() + " 执行了task: " + value);
                }
                return "call";
            }, 3, TimeUnit.SECONDS);// 3秒执行1次
            scheduledFuture.get();
        }
        executorService.shutdown();
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    @Test
    public void newSingleThreadExecutorTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int tempIndex = i;
            executorService.execute(() -> out.println(Thread.currentThread().getName() + "=>" + tempIndex));
            /**
             * 这样是修改不了当前执行线程名称的。
             * 原因：1、线程池只执行了线程的run方法，不启动对应的线程
             *      2、线程池线程名称要通过初始化线程池时，传入自定义ThreadFactory实现
             * executorService.execute(new Thread(() -> out.println(Thread.currentThread().getName() + "=>" + tempIndex),
             *      "pool-1-thread-" + tempIndex));
             */
        }
        executorService.shutdown();
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    @Test
    public void newCachedThreadPoolTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int tempIndex = i;
            executorService.execute(() -> out.println(Thread.currentThread().getName() + "=>" + tempIndex));
        }
        executorService.shutdown();
    }
}
