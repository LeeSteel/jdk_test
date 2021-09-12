package test.java.lang;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 测试Integer 的一些方法
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/6/4 16:54
 * @Copyright: Copyright (c) 2019
 */
public class IntegerTest {
    public static void main(String[] args) {

        doTestEquals1_1();
        doTestEquals1_2();

        doTestEquals2_1();
        doTestEquals2_2();

        //测试 new Integer()对象使用 == 比较
        doTestEquals3_1();
        doTestEquals3_2();
    }

    public static void doTestEquals1_1() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(" Integer a = 127;");
        System.out.println(" Integer b = 127;");
        System.out.println(" a == b : "+ (a == b));
        System.out.println("==========================");
    }
    public static void doTestEquals1_2() {
        Integer a = 128;
        Integer b = 128;
        System.out.println(" Integer a = 128;");
        System.out.println(" Integer b = 128;");
        System.out.println(" a == b : "+ (a == b));

        System.out.println("==========================");

    }
    public static void doTestEquals2_1() {
        int a = 127;
        int b = 127;
        System.out.println(" int a = 127;");
        System.out.println(" int b = 127;");
        System.out.println(" a == b : "+ (a == b));
        System.out.println("==========================");

    }
    public static void doTestEquals2_2() {
        Integer a = 127;
        int b = 127;
        System.out.println(" Integer a = 127;");
        System.out.println(" int b = 127;");
        System.out.println(" a == b : "+ (a == b));

        System.out.println("==========================");

    }
    public static void doTestEquals3_1() {
        Integer a = new Integer(128);
        Integer b =  new Integer(128);
        System.out.println(" Integer a = new Integer(128);");
        System.out.println(" Integer a = new Integer(128);");
        System.out.println(" a == b : "+ (a == b));
        System.out.println("==========================");

    }
    public static void doTestEquals3_2() {
        Integer a = new Integer(127);
        Integer b =  new Integer(127);
        System.out.println(" Integer a = new Integer(127);");
        System.out.println(" Integer a = new Integer(127);");
        System.out.println(" a == b : "+ (a == b));
        System.out.println("==========================");

    }


    public static void parseInt() {
        String str = "12345678910";
        //超过 int 最大的
        System.out.println(Integer.parseInt(str));

    }
}
