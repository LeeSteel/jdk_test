package test.java;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: switch case和if else效率区别
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/11 23:09
 * @Copyright: Copyright (c) 2019
 */
public class SwitchTests {

    @Test
    public void compareToIfElseTest() {
        long beginTimeMillis = System.currentTimeMillis();
        //switch
        //如果 case条件中的int值连续, 基于 跳表 tableswitch
        /**
         * tableswitch
         *
         *     tableswitch用来处理条件连续的情况。首先进行一次范围检查，检查不通过便直接返回default。检查通过后，会得到对应case语句的偏移量。
         *
         *     tableswitch使用数组结构存储偏移量，因此利用下标可以快速定位到偏移量，时间复杂度为O（1）。
         *
         *     注意：这里的“连续”可以理解为相对连续或半连续，012连续，013可以理解为半连续。
         *     013也会使用tableswitch，只不过里面缺少的2和default分支会有同样的偏移量。
         */

        //如果 case条件中的int值不 连续, 基于  lookupswitch
        /**
         * lookupswitch
         *
         *     lookupswitch则用来处理条件不连续的情况，当条件大面积不连续时，tableswitch将会产生大量的额外空间。
         *     使用lookupswitch，会将case值进行排序，之后可以利用二分法快速查到对应的分支偏移量。
         *
         *     lookupswitch则是维护了一个经过key排序的(key，value)结构，查找复杂度一般为O(logN)。
         */

        for (int i = 0; i < 1000000; i++) {
            doSwitchTest();
        }
        long endTimeMillis = System.currentTimeMillis();
        System.out.println(endTimeMillis - beginTimeMillis);
        for (int i = 0; i < 1000000; i++) {
            doIfElseTest();
        }
        System.out.println(System.currentTimeMillis() - endTimeMillis);


    }

    public void doSwitchTest() {
        String value = "A";
        switch (value) {
            case "A":
                break;
            case "B":
                break;
            case "C":
                break;
            case "D":
                break;
            case "E":
                break;
            case "F":
                break;
            default:
                break;
        }

    }

    public void doIfElseTest() {
        String value = "F";
        if ("A".equals(value)) {

        } else if ("B".equals(value)) {

        } else if ("C".equals(value)) {

        } else if ("D".equals(value)) {

        } else if ("E".equals(value)) {

        } else if ("F".equals(value)) {

        }
    }
}
