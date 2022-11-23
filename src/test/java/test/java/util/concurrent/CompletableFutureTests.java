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
        return "OK";
    }

    @SneakyThrows
    @Test
    public void getTest(){
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(CompletableFutureTests::sleepThreeSecondAndGetString);
        System.out.println(System.currentTimeMillis());

        String result = supplyAsync.get();
        System.out.println(System.currentTimeMillis());
        System.out.println(result);
    }
}