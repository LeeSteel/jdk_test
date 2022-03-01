package test.java;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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
    private static final List<Dog> dogList;

    static {
        dogList = new ArrayList() {{
            add(new Dog(10, "小黑"));
            add(new Dog(8, "小白"));
        }};
    }

    @Test
    public void unmodifiableListTest() {

        List<Dog> tempDogList = Collections.unmodifiableList(dogList);
        // tempDogList.add(new test.java.Dog(1, "小红花"));

        Dog dog = tempDogList.get(0);
        dog.setAge(99);

        List<Dog> tempDogList2 = new ArrayList<>();
        //   tempDogList2.addAll(tempDogList);

        tempDogList2.add(new Dog(2, "小绿花"));

        System.out.println("tempDogList:" + tempDogList.toString());
        System.out.println("tempDogList2:" + tempDogList2.toString());
        System.out.println("dogList:" + dogList.toString());

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



