package test.java.text;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: DecimalFormat 测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/6/29 13:46
 * @Copyright: Copyright (c) 2019
 */
public class DecimalFormatTests {

    @Test
    public void formatTest() {
        BigDecimal bigDecimal = new  BigDecimal("0.245566");
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println(df.format(bigDecimal));
    }

}
