package test.java.util;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import test.java.FinalTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/2/23 16:06
 * @Copyright: Copyright (c) 2019
 */
public class CollectionsTests {
    private static final List<Dog> staticFinalList;

    static {
        staticFinalList = new ArrayList() {{
            add(new FinalTests.Dog(10, "小黑"));
            add(new FinalTests.Dog(8, "小白"));
        }};
    }

    /**
     * 集合工具类 混淆 shuffle 测试
     */
    @Test
    public void shuffleTest() {
        List<String> list = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            list.add("" + i);
        }
        for (int i = 0; i < size; i++) {
            Collections.shuffle(list);
            System.out.println(list.toString());
        }
    }

    @Test
    public void unmodifiableListAddTest() {

        List<Dog> unmodifiableList = Collections.unmodifiableList(staticFinalList);
        unmodifiableList.add(new Dog(1, "小红花"));

        System.out.println("unmodifiableList:" + unmodifiableList.toString());
        System.out.println("staticFinalList:" + staticFinalList.toString());

    }
    @Test
    public void unmodifiableListTest() {

        List<Dog> unmodifiableList = Collections.unmodifiableList(staticFinalList);
        // unmodifiableList.add(new test.java.Dog(1, "小红花"));

        Dog dog = unmodifiableList.get(0);
        dog.setAge(99);

        List<Dog> tempList = new ArrayList<>();
        //   tempList.addAll(unmodifiableList);

        tempList.add(new Dog(2, "小绿花"));

        System.out.println("unmodifiableList:" + unmodifiableList.toString());
        System.out.println("tempList:" + tempList.toString());
        System.out.println("staticFinalList:" + staticFinalList.toString());

    }

    @Data
    @ToString
    public static class Dog {
        public Dog(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        private Integer age;
        private String name;
    }

}
