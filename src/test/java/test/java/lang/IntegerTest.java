package test.java.lang;

import org.junit.jupiter.api.Test;

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
    /**
     * 缓存以支持 JLS 要求的 -128 和 127（含）之间的值的自动装箱的对象标识语义。
     * 缓存在第一次使用时被初始化。
     * 缓存的大小可以由 {@code -XX:AutoBoxCacheMax=<size>} 选项控制。
     * 在VM初始化时，可以设置java.lang.Integer.IntegerCache.high
     * 属性并保存在sun.misc.VM类的私有系统属性中。
     */

    @Test
    public void doTestEquals1_1() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(" Integer a = 127;");
        System.out.println(" Integer b = 127;");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");
    }

    @Test
    public void doTestEquals1_2() {
        Integer a = 128;
        Integer b = 128;
        System.out.println(" Integer a = 128;");
        System.out.println(" Integer b = 128;");
        System.out.println(" a == b : " + (a == b));

        System.out.println("==========================");

    }

    @Test
    public void doTestEquals2_1() {
        int a = 127;
        int b = 127;
        System.out.println(" int a = 127;");
        System.out.println(" int b = 127;");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");

    }

    @Test
    public void doTestEquals2_2() {
        Integer a = 127;
        int b = 127;
        System.out.println(" Integer a = 127;");
        System.out.println(" int b = 127;");
        System.out.println(" a == b : " + (a == b));

        System.out.println("==========================");

    }

    @Test
    public void doTestEquals3_1() {
        Integer a = new Integer(128);
        Integer b = new Integer(128);
        System.out.println(" Integer a = new Integer(128);");
        System.out.println(" Integer a = new Integer(128);");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");

    }

    @Test
    public void doTestEquals3_2() {
        Integer a = new Integer(127);
        Integer b = new Integer(127);
        System.out.println(" Integer a = new Integer(127);");
        System.out.println(" Integer a = new Integer(127);");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");

    }

    @Test
    public void parseInt() {
        String str = "12345678910";
        //超过 int 最大的
        System.out.println(Integer.parseInt(str));

    }
}
