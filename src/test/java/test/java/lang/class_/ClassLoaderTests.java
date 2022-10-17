package test.java.lang.class_;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import  com.sun.nio.zipfs.ZipInfo;
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
public class ClassLoaderTests {


    @Test
    public void doBootstrapClassLoaderTest(){
        /**
         * Java类是由java.lang.ClassLoader的实例加载的，但是AppClassLoader本身就是一个Java类。因此谁来加载AppClassLoader（java.lang.ClassLoader）？
         *
         * 这就是BootstrapClassLoader发挥作用的地方了。
         *
         * BootstrapClassLoader负责加载JDK内部的类，
         * rt.jar和%JAVA_HOME%/lib目录下的其他核心库，
         * ext目录是扩展库。此外BootstrapClassLoader还是其他ClassLoader实例的爸爸。
         *
         * BootstrapClassLoader是JVM的一部分，它是由本机代码（C/C++）编写，在不同的平台上会有不同的实现。
         */
        System.out.println("ArrayList's  ClassLoader is " +
                ArrayList.class.getClassLoader());
    }

    @Test
    public void doExtClassLoaderTest(){
        /**
         * ExtClassLoader是BootstrapClassLoader的子类，它负责加载标准核心的Java扩展类，
         * 它从JDK的扩展目录%JAVA_HOME%/lib/ext/目录或环境变量java.ext.dirs目录下加载对应的扩展类。
         *
         */
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("ZipInfo's  ClassLoader is " +
                ZipInfo.class.getClassLoader());
    }


    @Test
    public void classLoaderTest() {
        /**
         * 双亲委派模型介绍
         * 每⼀个类都有⼀个对应它的类加载器。系统中的 ClassLoder 在协同⼯作的时候会默认使⽤ 双亲委派
         * 模型 。即在类加载的时候，系统会⾸先判断当前类是否被加载过。已经被加载的类会直接返回，否则
         * 才会尝试加载。加载的时候，⾸先会把该请求委派该⽗类加载器的 loadClass() 处理，因此所有的
         * 请求最终都应该传送到顶层的启动类加载器 BootstrapClassLoader 中。当⽗类加载器⽆法处理
         * 时，才由⾃⼰来处理。当⽗类加载器为null时，会使⽤启动类加载器 Bootstrap ClassLoader 作为
         * ⽗类加载器。
         */
        System.out.println("ClassLoaderTest's ClassLoader is " +
                ClassLoaderTests.class.getClassLoader());
        System.out.println("The Parent of ClassLoaderTest's ClassLoaderis " +
                ClassLoaderTests.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLoaderTest's  ClassLoader is " +
                ClassLoaderTests.class.getClassLoader().getParent().getParent());
    }

}
