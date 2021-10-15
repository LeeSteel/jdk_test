package test.java;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: switch case和if else效率区别
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/11 23:09
 * @Copyright: Copyright (c) 2019
 */
public class SwitchIfElseTest {

    public static void main(String[] args) {
        long beginTimeMillis = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            doSwitchTest();
        }
        long endTimeMillis = System.currentTimeMillis();
        System.out.println(endTimeMillis - beginTimeMillis);
        for (int i = 0; i < 100000; i++) {
            doIfElseTest();
        }
        System.out.println(System.currentTimeMillis() - endTimeMillis);


    }

    public static void doSwitchTest() {
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

    public static void doIfElseTest() {
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
