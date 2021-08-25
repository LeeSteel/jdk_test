package test.java.util.concurrent;

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
    public static void main(String[] args) {
        singleTheadPoolTest();

    }

    /**
     *创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    public static void singleTheadPoolTest() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            pool.execute(() -> out.println(Thread.currentThread().getName() + "=>" + ii));
        }

        pool.shutdown();
    }
}
