package test.java.util.hashset;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/28 11:11
 * @Copyright: Copyright (c) 2019
 */
public class HashSetTests {
    @Test
    public void addTest() {
        HashSet<Object> hashSet = new HashSet();
        hashSet.add(new HashSetBean());
        hashSet.add(new HashSetBean());
        hashSet.add(new HashSetBean());
        System.out.println(hashSet.size());
    }

    @Test
    public void addIntegerTest() {
        HashSet<Integer> hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(18);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.stream().forEach(System.out::println);
    }
}
