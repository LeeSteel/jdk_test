package test.java.lang;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/4/21 9:59
 * @Copyright: Copyright (c) 2019
 */
public class BooleanTests {
    /**
     * 引用地址 匹配
     */
    @Test
    public void addressMatchingTest() {
        Boolean aTrue = new Boolean(true);
        // 包装类非同一个对象,引用地址不同
        System.out.println(aTrue == Boolean.TRUE);// false

        boolean bTrue = true;
        // 基础数据类型 匹配引用类型,自动拆装箱,实际为 值匹配
        System.out.println(bTrue == Boolean.TRUE);//true
    }
}
