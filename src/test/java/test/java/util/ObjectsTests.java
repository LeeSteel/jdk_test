package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/5/11 15:30
 * @Copyright: Copyright (c) 2019
 */
public class ObjectsTests {

    @Test
    public void equalsTest(){
        // Objects 类 1.7版本引入,提供了允许 空值的 equals 方法
        Integer a = null;
        Integer b = 100;
        System.out.println(Objects.equals(a,b));
    }
}
