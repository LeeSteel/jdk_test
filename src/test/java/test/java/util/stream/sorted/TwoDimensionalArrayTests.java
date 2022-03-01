package test.java.util.stream.sorted;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 二维数组 验证类
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/15 16:15
 * @Copyright: Copyright (c) 2019
 */
public class TwoDimensionalArrayTests {

    @Test
    public void flatMapToIntTest() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] b = Arrays.stream(arr).flatMapToInt(x -> Arrays.stream(x)).toArray();
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.stream(b).sum());

    }
}
