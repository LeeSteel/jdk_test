package test.java.util.concurrent.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/10/20 11:09
 * @Copyright: Copyright (c) 2019
 */
public class AtomicReferenceTests {
    /**
     * 获取CPU 核数
     */
    private static int processorsCount = (Runtime.getRuntime() != null && Runtime.getRuntime().availableProcessors() > 0) ?
            Runtime.getRuntime().availableProcessors() : 8;
    private static final ExecutorService EXECUTOR_SERVICE =
            new ThreadPoolExecutor(processorsCount, processorsCount * 8,
                    60L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(1000000));




    /**
     * 同步环境下 AtomicInteger#getAndAdd 测试(计算 1+2+...+100 = 5050)
     */
    @Test
    public void getTest() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicReference<AtomicInteger> atomicReference = new AtomicReference(atomicInteger);
        atomicReference.get().getAndIncrement();

        System.out.println(atomicReference.get().intValue());
    }
}
