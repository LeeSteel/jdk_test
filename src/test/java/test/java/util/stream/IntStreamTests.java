package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:  IntStream 测试
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/9/6 11:53
 * @Copyright: Copyright (c) 2019
 */
public class IntStreamTests {

    /**
     * peek 查看流元素通过时的值,不会影响到原有值
     */
    @Test
    public void peekTest() {
        IntStream.of(1, 2, 3, 4)
                .filter(e -> e > 2)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(e -> e * e)
                .peek(e -> System.out.println("Mapped value: " + e))
                .sum();
    }

    /**
     * peek 查看流元素通过时的值,不会影响到原有值
     */
    @Test
    public void reduceTest() {
      int result =   IntStream.of(1, 2, 3, 4).reduce(0,(a,b)->a+b);
        System.out.println(result);
    }
    /**
     * range 范围值,  不包含 结束值 [1,100)
     * 即  for (int i = startInclusive; i < endExclusive ; i++) { ... }
     */
    @Test
    public void rangeTest(){
        int sum = IntStream.range(1, 100).sum();
        System.out.println(sum);

    }
    /**
     * rangeClosed 范围值,  包含 结束值 [1,100]
     * 即  for (int i = startInclusive; i <= endExclusive ; i++) { ... }
     */
    @Test
    public void rangeClosedTest(){
        int sum = IntStream.rangeClosed(1, 100).sum();
        System.out.println(sum);

    }
}
