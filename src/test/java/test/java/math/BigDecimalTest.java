package test.java.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    /**
     * 结论：
     * BigDecimal 数值 低于指定的小数位scale时,设置 scale不生效
     */
    @Test
    public void setScaleTest() {
        // eg 1
        double aValue = 1.000;
        BigDecimal aBig = BigDecimal.valueOf(aValue);
        aBig.setScale(5);
        System.out.println("aBig scale:" + aBig.scale());
        System.out.println("aBig value:" + aBig.toString());

        // eg 2
        double bValue = 1.123456;
        BigDecimal bBig = BigDecimal.valueOf(bValue);
        bBig.setScale(10, RoundingMode.HALF_DOWN);
        System.out.println("bBig scale:" + bBig.scale());
        System.out.println("bBig value:" + bBig.toString());
    }


    /**
     * 结论：
     * BigDecimal  double 构造函数 精度是不可控的
     * BigDecimal  String 构造函数 精度是正确的
     * 尽量使用 BigDecimal.valueOf 来生成 BigDecimal
     */
    @Test
    public void equalsTest() {
        double aValue = 1.0;
        BigDecimal aBig = new  BigDecimal(aValue);
        System.out.println(aBig.toString());
        System.out.println(aBig.equals(BigDecimal.ONE));

    }
}
