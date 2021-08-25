package test.java.util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/4/7 22:41
 * @Copyright: Copyright (c) 2019
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(22);

        ConcurrentHashMap<String, String> concurrentHashMap1 = new ConcurrentHashMap<>(22, 0.75F, 1);

        Map<String, String> concurrentHashMap2 = new ConcurrentHashMap();

    }


}
