package test.java.util.hashmap;

import org.junit.jupiter.api.Test;
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
public class HashMapTests {
    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 添加 Hash 冲突的 bean 测试
     * 主要是观察 hash冲突时候的 HashMap 内部 Node链表  与红黑树的转化
     */
    @Test
    public void putHashConflictBeanTest() {

        Map<Object, Object> map = new HashMap<>();

        int size = 23;
        for (int i = 0; i < size; i++) {
            map.put(i+"", new Object());
        }
        for (int i = 0; i < size; i++) {
            map.put(new HashKeyTestBean(), new Object());
        }


        System.out.println(map.size());
    }

    @Test
    public void tableSizeForTest() {
        int cap = 8;
        System.out.println(tableSizeFor(cap));
         cap = 20;
        System.out.println(tableSizeFor(cap));
    }

    /**
     *  返回给定目标容量 最近的 2 次方。
     *  同 java.util.HashMap 中 tableSizeFor(int cap) 方法
     * @param cap
     * @see java.util.HashMap 中 tableSizeFor(int cap) 方法
     *
     * @return
     */
    public int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}


