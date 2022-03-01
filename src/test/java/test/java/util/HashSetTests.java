package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/5/3 14:24
 * @Copyright: Copyright (c) 2019
 */
public class HashSetTests {
    /**
     * 添加 null 值 测试
     */
    @Test
    public void addNullValueTest() {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add(null));
        System.out.println(hashSet.add(null));
    }

}
