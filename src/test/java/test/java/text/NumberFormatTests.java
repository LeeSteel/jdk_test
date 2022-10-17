package test.java.text;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/7/1 15:33
 * @Copyright: Copyright (c) 2019
 */
public class NumberFormatTests {

    @Test
    public void doTest(){
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        BigDecimal result = BigDecimal.valueOf(39).divide(BigDecimal.valueOf(40),2,BigDecimal.ROUND_FLOOR);
        System.out.println(numberFormat.format(result));
    }
}
