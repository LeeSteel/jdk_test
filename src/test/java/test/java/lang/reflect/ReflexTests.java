package test.java.lang.reflect;

import org.junit.jupiter.api.Test;
import test.java.lang.reflect.domain.ReflexTestSonBean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
public class ReflexTests {


    /**
     * 测试反射是否能够获取到父类属性
     *
     * @throws Exception
     */
    @Test
    public void getDeclaredFieldsTest() throws Exception {

        Class<?> testClass = Class.forName("test.java.lang.reflect.domain.ReflexTestSonBean");
        //getDeclaredFields() 可以拿到反射类中的公共字段、私有字段、保护字段、默认访问，但不获得继承的字段。
        //getFields() 可以拿到反射类及其父类中的所有公共字段。
        Field[] fields = testClass.getDeclaredFields();
        Object sonBean = testClass.getDeclaredConstructor().newInstance();
        Field sonName = testClass.getDeclaredField("sonName");
        //为true 关闭访问检查
        sonName.setAccessible(true);
        sonName.set(sonBean,"testSon");

        Class<?> superclass = testClass.getSuperclass();
        Field fatherName = superclass.getDeclaredField("fatherName");
        //为true 关闭访问检查
        fatherName.setAccessible(true);
        fatherName.set(sonBean,"testFather");
        System.out.println(((ReflexTestSonBean)sonBean).getSonName());
        System.out.println(((ReflexTestSonBean)sonBean).getFatherName());


    }

    /**
     * 测试反射是否能够获取到父类方法
     *
     * @throws Exception
     */
    @Test
    public  void getMethodsTest() throws Exception {

        Class<?> testClass = Class.forName("test.java.lang.reflect.domain.ReflexTestSonBean");
        //getDeclaredMethods() 可以拿到反射类中的公共方法、私有方法、保护方法、默认访问，但不获得继承的方法。
        //getMethods() 可以拿到反射类及其父类中的所有公共方法。
        Method[] methods = testClass.getMethods();
        Map<String, List<Method>> classMap = new HashMap<>();
        for (Method method : methods) {
            String className = method.getDeclaringClass().getName();
            //1、父类私有方法无法直接获得，需要 getSuperclass，然后才能获得
            //2、重写了父类方法后，无法获取原父方法

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
     * 测试反射是否能够 执行 私有方法
     *
     * @throws Exception
     */
    @Test
    public  void privateMethodTest() throws Exception {

        Class<?> testClass = Class.forName("test.java.lang.reflect.domain.ReflexTestSonBean");
        Object instance = testClass.getDeclaredConstructor().newInstance();
        Method method = testClass.getDeclaredMethod("method");
        method.invoke(instance);

        Method sonPriMethod = testClass.getDeclaredMethod("sonPriMethod");
        //为true 关闭访问检查
        sonPriMethod.setAccessible(true);
        sonPriMethod.invoke(instance);
    }
}
