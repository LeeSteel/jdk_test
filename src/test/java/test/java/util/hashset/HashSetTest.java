package test.java.util.hashset;

import java.util.HashSet;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/28 11:11
 * @Copyright: Copyright (c) 2019
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet();
        hashSet.add(new HashSetBean());
        hashSet.add(new HashSetBean());
        hashSet.add(new HashSetBean());
        System.out.println(hashSet.size());
    }
}
