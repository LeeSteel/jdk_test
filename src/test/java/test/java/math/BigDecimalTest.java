package test.java.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/6/1 16:40
 * @Copyright: Copyright (c) 2019
 */
public class BigDecimalTest {

    /**
     * 测试 BigDecimal.valueOf(double) 精度是否准确
     * 结论：
     *  BigDecimal.valueOf(double) 精度是准确的
     */
    @Test
    public void valueOfDoubleTest() {
        double value = 0.1;
        BigDecimal decimal = BigDecimal.valueOf(value);
        System.out.println(decimal.toString());
    }

    /**
     * 结论：
     * BigDecimal  double 构造函数 精度是不可控的
     * BigDecimal  String 构造函数 精度是正确的
     * 尽量使用 BigDecimal.valueOf 来生成 BigDecimal
     */
    @Test
    public void doubleConstructorPrecisionTest() {
        double value = 0.1;
        BigDecimal bigDecimalDouble = new BigDecimal(value);
        System.out.println(bigDecimalDouble.toString());
        BigDecimal bigDecimalStr = new BigDecimal("" + value);
        System.out.println(bigDecimalStr.toString());

    }


}
