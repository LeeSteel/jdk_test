package test.java.util.function;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/3 18:22
 * @Copyright: Copyright (c) 2019
 */
public class SupplierTests {


    @Test
    public void getTest() {
        Supplier<Integer> supplier = () -> new Random().nextInt(10);
        System.out.println(supplier.get());
        System.out.println(supplier.get());

        Supplier<LocalDateTime> supplier2 = LocalDateTime::now;
        System.out.println(supplier2.get());
        System.out.println(supplier2.get());
    }

    @Test
    public void functionParamTest() {
        FunctionBean xiaoM = beanFactory(() -> new FunctionBean("小明"));
        FunctionBean xiaoH = beanFactory(() -> new FunctionBean("小红"));
        System.out.println(xiaoM);
        System.out.println(xiaoH);
    }

    private FunctionBean beanFactory(Supplier<? extends FunctionBean> supplier) {
        FunctionBean bean = supplier.get();
        bean.setBeanId(new Random().nextInt(10));
        return bean;
    }


    /**
     *  Supplier 扩展类，限定了类型
     */
    @Test
    public void intSupplierTest(){
        IntSupplier intSupplier = () -> new Random().nextInt(10);
        System.out.println(intSupplier.getAsInt());
        System.out.println(intSupplier.getAsInt());
    }
}
