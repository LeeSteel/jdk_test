package test.java;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢
 * @date: 2021/9/6 11:14
 * @Copyright: Copyright (c) 2019
 */

public class FinallyTests {
    /**
     * 测试  return 和 finally的优先级
     * 结论： finally 代码块 无论如何都会执行, 如果finally 里也有 return,则 已finally 里 return 为准
     */
    @Test
    public void finallyReturnTest() {
        System.out.println(mockMethod(3));
        System.out.println(mockMethod(2));
    }

    /**
     * @param value
     * @return
     */
    public int mockMethod(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }

}
