package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/12/6 15:01
 * @Copyright: Copyright (c) 2019
 */
public class ArraysTests {

    @Test
    public void asListTest(){
        // 注意：返回的是 Arrays.内部类ArrayList
        List<String> strList = Arrays.asList("a", "b", "c");
        System.out.println(strList.contains("a"));
    }


    /**
     * 二分查找测试
     */
    @Test
    public void binarySearchTest(){
        //
        int[] randArray =  new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(10)
                .sorted().toArray() ;
        System.out.println(Arrays.toString(randArray));
        System.out.println(Arrays.binarySearch(randArray,12));
    }

}
