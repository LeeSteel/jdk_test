package test.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:   BiConsumer是Java 1.8版本中新增的函数式接口之一，它表示接受两个参数并执行某些操作的函数，不返回结果
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/6/1 18:19
 * @Copyright: Copyright (c) 2019
 */
public class BiConsumerTests {
    @Test
    public void simpleTest() {
        BiConsumer<Double, Double> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept(1.0, 2.0);
    }


}
