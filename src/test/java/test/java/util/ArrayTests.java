package test.java.util;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/3/15 19:01
 * @Copyright: Copyright (c) 2019
 */
public class ArrayTests {

    @Test
    public void errorInitLengthTest() {
        String[] strings = new String[-1];
    }


    @Test
    public void arrayLengthTest() {
        String[] strings = new String[10];
        System.out.println(strings.length);
    }
}
