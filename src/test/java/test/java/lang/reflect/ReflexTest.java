package test.java.lang.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        doGetMethodsTest();
    }

    /**
     * 测试反射是否能够获取到父类方法
     *
     * @throws Exception
     */
    public static void doGetMethodsTest() throws Exception {

        Class<?> testClass = Class.forName("test.java.lang.reflect.domain.ReflexTestSonBean");
        Object instance = testClass.getDeclaredConstructor().newInstance();
        Method[] methods = testClass.getMethods();
        Map<String, List<Method>> classMap = new HashMap<>();
        for (Method method : methods) {
            String className = method.getDeclaringClass().getName();
            List<Method> methodList = classMap.get(className);
            if (methodList == null) {
                methodList = new ArrayList<>();
                classMap.put(className, methodList);
            }
            methodList.add(method);

        }

        classMap.forEach((className, methodsList) -> {
            System.out.println("类:" + className + "中方法有:" + methodsList.size() + "个");
        });

    }

    /**
     * 测试反射是否能够获取到父类方法
     *
     * @throws Exception
     */
    public static void doTest() throws Exception {

        Class<?> testClass = Class.forName("test.java.lang.reflect.domain.ReflexTestSonBean");
        Object instance = testClass.getDeclaredConstructor().newInstance();
        Method[] methods = testClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        Method method = testClass.getDeclaredMethod("method");
        method.invoke(instance);

        Method sonPriMethod = testClass.getDeclaredMethod("sonPriMethod");
        //为true 关闭访问检查
        sonPriMethod.setAccessible(true);
        sonPriMethod.invoke(instance);
    }
}
