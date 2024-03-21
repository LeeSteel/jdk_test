package test.java.util.concurrent;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/16 16:00
 * @Copyright: Copyright (c) 2019
 */
public class CompletableFutureTests {

    @SneakyThrows
    private static String sleepThreeSecondAndGetString() {
        Thread.sleep(3 * 1000L);
        System.out.println(Thread.currentThread().getName());
        return "OK";
    }
    @SneakyThrows
    private static void sleepThreeSecond() {
        Thread.sleep(3 * 1000L);
        System.out.println(Thread.currentThread().getName());

    }

    @SneakyThrows
    @Test
    public void supplyAsyncTest(){
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(CompletableFutureTests::sleepThreeSecondAndGetString);
        System.out.println(System.currentTimeMillis());

        String result = supplyAsync.get();
        System.out.println(System.currentTimeMillis());
        System.out.println(result);
    }

    /**
     *  CompletableFuture 异步运行测试
     */
    @Test
    public void runAsyncTest() {
        CompletableFuture runAsync = CompletableFuture.runAsync(CompletableFutureTests::sleepThreeSecond);
        System.out.println(System.currentTimeMillis());
        runAsync.join();
        System.out.println(System.currentTimeMillis());

    }
}
