package test.java.util.hashmap;

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
public class HashMapLoopTest {

    public static void main(String[] args) {
        Map<String, Object> testMap = initData();
        doTestLoop1(testMap);
        doTestLoop2(testMap);
        doTestLoop3(testMap);
        doTestLoop4(testMap);
    }

    public static Map<String, Object> initData() {
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("1", 1);
        testMap.put("2", 2);
        testMap.put("3", 3);
        return testMap;
    }

    public static void doTestLoop1(Map<String, Object> map) {
        System.out.println("循环方式1");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.print("key:" + entry.getKey() + "\t");
            System.out.print("value:" + entry.getValue());
            System.out.println("");
        }
    }

    public static void doTestLoop2(Map<String, Object> map) {
        System.out.println("循环方式2");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.print("key:" + entry.getKey() + "\t");
            System.out.print("value:" + entry.getValue());
            System.out.println("");
        }
    }

    public static void doTestLoop3(Map<String, Object> map) {
        System.out.println("循环方式3");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print("key:" + key + "\t");
            System.out.print("value:" + map.get(key));
            System.out.println("");
        }
    }

    public static void doTestLoop4(Map<String, Object> map) {
        System.out.println("循环方式4");
        map.forEach((key, value) -> {
            System.out.print("key:" + key + "\t");
            System.out.print("value:" + value);
            System.out.println("");
        });
    }
}
