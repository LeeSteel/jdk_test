package test.java.util;

import java.util.Hashtable;
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
public class HashTableTest {
    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        Map<HashKeyTestBean, Object> map = new Hashtable<HashKeyTestBean, Object>();
        int oldCapacity = Integer.MAX_VALUE -8;
        int newCapacity = (oldCapacity << 1) + 1;

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


}


