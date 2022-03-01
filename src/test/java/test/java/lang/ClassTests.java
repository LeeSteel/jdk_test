package test.java.lang;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 双亲委派模型介绍
 * <p>
 * 每⼀个类都有⼀个对应它的类加载器。系统中的 ClassLoder 在协同⼯作的时候会默认使⽤ 双亲委派
 * 模型 。即在类加载的时候，系统会⾸先判断当前类是否被加载过。已经被加载的类会直接返回，否则
 * 才会尝试加载。加载的时候，⾸先会把该请求委派该⽗类加载器的 loadClass() 处理，因此所有的
 * 请求最终都应该传送到顶层的启动类加载器 BootstrapClassLoader 中。当⽗类加载器⽆法处理
 * 时，才由⾃⼰来处理。当⽗类加载器为null时，会使⽤启动类加载器 BootstrapClassLoader 作为
 * ⽗类加载器。
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/6 17:45
 * @Copyright: Copyright (c) 2019
 */
public class ClassTests {
    @Test
    public void classLoaderTest() {
        /**
         * 双亲委派模型介绍
         * 每⼀个类都有⼀个对应它的类加载器。系统中的 ClassLoder 在协同⼯作的时候会默认使⽤ 双亲委派
         * 模型 。即在类加载的时候，系统会⾸先判断当前类是否被加载过。已经被加载的类会直接返回，否则
         * 才会尝试加载。加载的时候，⾸先会把该请求委派该⽗类加载器的 loadClass() 处理，因此所有的
         * 请求最终都应该传送到顶层的启动类加载器 BootstrapClassLoader 中。当⽗类加载器⽆法处理
         * 时，才由⾃⼰来处理。当⽗类加载器为null时，会使⽤启动类加载器 BootstrapClassLoader 作为
         * ⽗类加载器。
         */
        System.out.println("ClassLoaderTest's ClassLoader is " +
                ClassTests.class.getClassLoader());
        System.out.println("The Parent of ClassLoaderTest's ClassLoaderis " +
                ClassTests.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLoaderTest's  ClassLoader is " +
                ClassTests.class.getClassLoader().getParent().getParent());
    }
}
