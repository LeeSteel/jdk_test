package test.java;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢
 * @date: 2021/9/6 11:14
 * @Copyright: Copyright (c) 2019
 */
public class FinallyTest {

    public static void main(String[] args) {
        System.out.println(testFinallyReturn(3));
        System.out.println(testFinallyReturn(2));
    }

    public static int testFinallyReturn(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }

}
