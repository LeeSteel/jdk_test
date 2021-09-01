package test.java.util.hashmap;

import test.java.util.HashKeyTestBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/3/9 20:49
 * @Copyright: Copyright (c) 2019
 */
public class HashMapTest {
    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        Map<HashKeyTestBean, Object> map = new HashMap<HashKeyTestBean, Object>();


        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());
        map.put(new HashKeyTestBean(), new Object());

        System.out.println(map.size());
    }

    public static int size(int cap) {

        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}


