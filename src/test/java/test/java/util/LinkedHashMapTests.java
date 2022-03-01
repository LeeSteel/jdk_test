package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢
 * @date: 2021/5/29 17:48
 * @Copyright: Copyright (c) 2019
 */
public class LinkedHashMapTests {
    @Test
    public void putElementTest() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
    }
}
