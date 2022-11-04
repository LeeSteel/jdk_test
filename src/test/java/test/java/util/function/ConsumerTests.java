package test.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/4 11:40
 * @Copyright: Copyright (c) 2019
 */
public class ConsumerTests {
    @Test
    public void acceptPrintlnTest() {
        Consumer<String> printlnFunction = System.out::println;
        printlnFunction.accept("www.baidu.com");
    }

    @Test
    public void acceptForEachTest() {
        Consumer<String> printConsumer = System.out::println;
        List<String> list = Arrays.asList("java", "node", "www.baidu.com");

        forEach(list, printConsumer);
        System.out.println("======================");
        forEach(list, s -> System.out.println(s.length()));
    }

    private <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
