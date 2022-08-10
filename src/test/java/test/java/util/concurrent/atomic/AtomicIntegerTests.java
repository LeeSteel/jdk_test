package test.java.util.concurrent.atomic;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: AtomicInteger 测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/8/9 17:18
 * @Copyright: Copyright (c) 2019
 */
public class AtomicIntegerTests {

    /**
     * 获取CPU 核数
     */
    private static int processorsCount = (Runtime.getRuntime() != null && Runtime.getRuntime().availableProcessors() > 0) ?
            Runtime.getRuntime().availableProcessors() : 8;
    private static final ExecutorService EXECUTOR_SERVICE =
            new ThreadPoolExecutor(processorsCount, processorsCount * 8,
                    60L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(1000000));

    volatile AtomicInteger volatileAtomicInteger = new AtomicInteger();
    /**
     * 同步环境下 AtomicInteger#getAndAdd 测试(计算 1+2+...+100 = 5050)
     */
    @Test
    public void getAndAddSyncTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int size = 100;
        for (int i = 1; i <= size; i++) atomicInteger.getAndAdd(i);
        System.out.println(atomicInteger.intValue());
    }


    /**
     * 异步环境下 AtomicInteger#getAndAdd 测试(计算 1+2+...+100 = 5050)
     */
    @Test
    @SneakyThrows
    public void getAndAddAsyncTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int size = 100;
        for (int i = 1; i <= size; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(() -> atomicInteger.getAndAdd(finalI));
        }

        EXECUTOR_SERVICE.shutdown(); // 线程池停止
        EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES); // 等待线程池停止，即所有线程执行完毕

        System.out.println(atomicInteger.intValue());
    }

    /**
     * 异步环境下 AtomicInteger#getAndAdd 测试(计算 1+2+...+100 = 5050)
     *  synchronized 对象锁
     */
    @SneakyThrows
    @Test
    public void getAndAddAsyncSynchronizedTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int size = 100;
        for (int i = 1; i <= size; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(() ->{
                synchronized (atomicInteger){
                    atomicInteger.getAndAdd(finalI);
                }
            });
        }
        EXECUTOR_SERVICE.shutdown(); // 线程池停止
        EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES); // 等待线程池停止，即所有线程执行完毕

        System.out.println(atomicInteger.intValue());
    }

    /**
     * 异步环境下 AtomicInteger#getAndAdd 测试(计算 1+2+...+100 = 5050)
     */
    @SneakyThrows
    @Test
    public void getAndAddAsyncLockTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Lock lock = new ReentrantLock(true);
        int size = 100;
        for (int i = 1; i <= size; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.submit(() -> {
                lock.lock();
                atomicInteger.getAndAdd(finalI);
                lock.unlock();
            });
        }
        EXECUTOR_SERVICE.shutdown(); // 线程池停止
        EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES); // 等待线程池停止，即所有线程执行完毕

        System.out.println(atomicInteger.intValue());
    }
    /**
     * 异步环境下 AtomicInteger#getAndAdd 测试(计算 1+2+...+100 = 5050)
     */
    @Test
    @SneakyThrows
    public void getAndAddAsyncVolatileTest() {
        int size = 100;
        for (int i = 1; i <= size; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(() -> volatileAtomicInteger.getAndAdd(finalI));
        }
        EXECUTOR_SERVICE.shutdown(); // 线程池停止
        EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES); // 等待线程池停止，即所有线程执行完毕

        System.out.println(volatileAtomicInteger.intValue());
    }

    /**
     * 异步环境下 AtomicInteger#compareAndSet 测试(计算 1+2+...+100 = 5050)
     */
    @Test
    @SneakyThrows
    public void compareAndSetAsyncVolatileTest() {
        int size = 100;
        for (int i = 1; i <= size; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(() -> volatileAtomicInteger.compareAndSet(volatileAtomicInteger.intValue(),finalI));
        }
        EXECUTOR_SERVICE.shutdown(); // 线程池停止
        EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES); // 等待线程池停止，即所有线程执行完毕

        System.out.println(volatileAtomicInteger.intValue());
    }
}
