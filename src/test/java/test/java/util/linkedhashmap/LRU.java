package test.java.util.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: Java LRU 算法实现,基于 LinkedHashMap
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/6/20 23:38
 * @Copyright: Copyright (c) 2019
 */
public class LRU extends LinkedHashMap {
    int capacity;

    public LRU(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
