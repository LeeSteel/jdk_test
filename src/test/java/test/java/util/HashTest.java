package test.java.util;

import java.util.Arrays;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/3/15 23:17
 * @Copyright: Copyright (c) 2019
 */
public class HashTest {
    public static void main(String[] args) {
        int length = 1 << 4;
        int[] arrayA = new int[length];
        int[] arrayB = new int[length];
        for (int i = 0; i < 100; i++) {
            arrayA[i & (length - 1)] = i;
        }
        for (int i = 0; i < 100; i++) {
            arrayB[i % length] = i;
        }
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
    }
}
