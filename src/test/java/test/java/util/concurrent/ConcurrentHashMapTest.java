package test.java.util.concurrent;

import org.junit.jupiter.api.Test;

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

    @Test
    public void initTest() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(22);

        ConcurrentHashMap<String, String> concurrentHashMap1 = new ConcurrentHashMap<>(22, 0.75F, 1);

        Map<String, String> concurrentHashMap2 = new ConcurrentHashMap();

        System.out.println(concurrentHashMap.size());
        System.out.println(concurrentHashMap1.size());
        System.out.println(concurrentHashMap2.size());
    }


}
