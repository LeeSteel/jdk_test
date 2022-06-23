package test.java.util.linkedhashmap;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Random;

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
        System.out.println(linkedHashMap);
    }

    @Test
    public void lruTest(){
        LRU lru = new LRU(16);
        Random random = new Random();

        for (int i = 0; i < 32; i++) {
            int nextInt = random.nextInt(10);
            System.out.println(nextInt);
            lru.put(Integer.valueOf(i),Integer.valueOf(i));
            lru.get(Integer.valueOf(nextInt));
            System.out.println(lru.toString());
        }

    }
}
