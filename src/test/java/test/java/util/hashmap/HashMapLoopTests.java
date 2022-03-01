package test.java.util.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: HashMap 循环测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/1 16:12
 * @Copyright: Copyright (c) 2019
 */
public class HashMapLoopTests {
    Map<String, Object> loopData;

    @BeforeEach
    public void inintData() {
        loopData = new HashMap<>();
        loopData.put("1", 1);
        loopData.put("2", 2);
        loopData.put("3", 3);

    }

    @Test
    public void loopTest() {
        loopForEntrySet(loopData);
        loopForEntrySetIterator(loopData);
        loopForKeySet(loopData);
        loopForForEach(loopData);
    }


    public static void loopForEntrySet(Map<String, Object> map) {
        System.out.println("循环方式1 : Map.Entry");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.print("key:" + entry.getKey() + "\t");
            System.out.print("value:" + entry.getValue());
            System.out.println("");
        }
    }

    public static void loopForEntrySetIterator(Map<String, Object> map) {
        System.out.println("循环方式2 :map.entrySet().Iterator()");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.print("key:" + entry.getKey() + "\t");
            System.out.print("value:" + entry.getValue());
            System.out.println("");
        }
    }

    public static void loopForKeySet(Map<String, Object> map) {
        System.out.println("循环方式3 : map.keySet()");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print("key:" + key + "\t");
            System.out.print("value:" + map.get(key));
            System.out.println("");
        }
    }

    public static void loopForForEach(Map<String, Object> map) {
        System.out.println("循环方式4 : map.forEach");
        map.forEach((key, value) -> {
            System.out.print("key:" + key + "\t");
            System.out.print("value:" + value);
            System.out.println("");
        });
    }
}
