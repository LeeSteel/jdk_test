package test.java.lang.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 反射测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/1 11:15
 * @Copyright: Copyright (c) 2019
 */
public class ReflexTest {
    public static void main(String[] args) throws Exception {

        doTest();
    }

    public static void doTest() throws Exception {

        Class<?> testClass = Class.forName("test.java.lang.reflect.domain.ReflexTestSonBean");
        Object instance = testClass.getDeclaredConstructor().newInstance();
        Method[] methods = testClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        Method method = testClass.getDeclaredMethod("method");
        method.invoke(instance);

        Method sonPriMethod = testClass.getDeclaredMethod("sonPriMethod");
        sonPriMethod.setAccessible(true);
        sonPriMethod.invoke(instance);
    }
}
