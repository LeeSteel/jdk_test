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
public class IntegerTests {
    /**
     * 缓存以支持 JLS 要求的 -128 和 127（含）之间的值的自动装箱的对象标识语义。
     * 缓存在第一次使用时被初始化。
     * 缓存的大小可以由 {@code -XX:AutoBoxCacheMax=<size>} 选项控制。
     * 在VM初始化时，可以设置java.lang.Integer.IntegerCache.high
     * 属性并保存在sun.misc.VM类的私有系统属性中。
     */

    @Test
    public void integerInCacheOperatorCompareTest() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(" Integer a = 127;");
        System.out.println(" Integer b = 127;");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");
    }

    @Test
    public void integerOutCacheOperatorCompareTest() {
        Integer a = 128;
        Integer b = 128;
        System.out.println(" Integer a = 128;");
        System.out.println(" Integer b = 128;");
        System.out.println(" a == b : " + (a == b));

        System.out.println("==========================");

    }

    @Test
    public void intOperatorCompareTest() {
        int a = 127;
        int b = 127;
        System.out.println(" int a = 127;");
        System.out.println(" int b = 127;");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");

    }

    @Test
    public void intIntegerInCacheOperatorCompareTest() {
        Integer a = 127;
        int b = 127;
        System.out.println(" Integer a = 127;");
        System.out.println(" int b = 127;");
        System.out.println(" a == b : " + (a == b));

        System.out.println("==========================");

    }

    @Test
    public void newIntegerOutCacheOperatorCompareTest() {
        Integer a = new Integer(128);
        Integer b = new Integer(128);
        System.out.println(" Integer a = new Integer(128);");
        System.out.println(" Integer a = new Integer(128);");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");

    }

    @Test
    public void newIntegerInCacheOperatorCompareTest() {
        Integer a = new Integer(127);
        Integer b = new Integer(127);
        System.out.println(" Integer a = new Integer(127);");
        System.out.println(" Integer a = new Integer(127);");
        System.out.println(" a == b : " + (a == b));
        System.out.println("==========================");

    }

    @Test
    public void parseIntOutIntegerMaxValueTest() {
        String str = "12345678910";
        //超过 int 最大的
        System.out.println(Integer.parseInt(str));
    }

    /**
     *  compareTo
     *  返回  -1 小于
     *  返回  0  等于
     *  返回  1  大于
     */
    @Test
    public void compareToTest() {
        Integer a = 1;
        Integer b = 2;
        /**
         *  compareTo
         *  返回  -1 小于
         *  返回  0  等于
         *  返回  1  大于
         *
         *  等同于 Integer.compare
         */
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));

    }
    /**
     *  compare
     *  返回  -1 小于
     *  返回  0  等于
     *  返回  1  大于
     */
    @Test
    public void compareTest() {
        Integer a = 1;
        Integer b = 2;
        /**
         *  compare
         *  返回  -1 小于
         *  返回  0  等于
         *  返回  1  大于
         *
         */
        System.out.println(Integer.compare(a,b));
        System.out.println(Integer.compare(b,a));

    }
}
