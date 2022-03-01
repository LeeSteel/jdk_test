package test.java;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/3/6 20:08
 * @Copyright: Copyright (c) 2019
 */
public class FinalTests {
    private static final List<Dog> staticFinalList;

    static {
        staticFinalList = new ArrayList() {{
            add(new Dog(10, "小黑"));
            add(new Dog(8, "小白"));
        }};
    }
    @Test
    public void finalListAddTest() {
        staticFinalList.add(new Dog(1, "小红花"));
        System.out.println("dogList:" + staticFinalList.toString());
    }
    @Test
    public void finalListRemoveTest() {
        staticFinalList.remove(0);
        System.out.println("dogList:" + staticFinalList.toString());
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



