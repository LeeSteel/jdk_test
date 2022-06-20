package test.java.util.concurrent.locks;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import test.java.util.concurrent.locks.domain.DieLockBean;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 死锁测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/6/17 11:44
 * @Copyright: Copyright (c) 2019
 */
public class DieLockTests {

    @Test
    public void dieLockTest() {
        DieLockBean targetOne = new DieLockBean("targetOne");
        DieLockBean targetTwo = new DieLockBean("targetTwo");
        new Thread(() -> toLock(targetOne, targetTwo), "ThreadA").start();
        new Thread(() -> toLock(targetTwo, targetOne), "ThreadB").start();

        // 避免主线程关闭后 子线程销毁
        while (true){}
    }
    @Test
    @SneakyThrows
    public void dieLockJoinTest() {
        DieLockBean targetOne = new DieLockBean("targetOne");
        DieLockBean targetTwo = new DieLockBean("targetTwo");
        Thread threadA = new Thread(() -> toLock(targetOne, targetTwo), "ThreadA");
        threadA.start();
        threadA.join();
        new Thread(() -> toLock(targetTwo, targetOne), "ThreadB").start();

        // 避免主线程关闭后 子线程销毁
        while (true){}
    }
    public void toLock(DieLockBean targetOne, DieLockBean targetTwo) {
        synchronized (targetOne) {
            System.out.println(Thread.currentThread().getName() + " 锁   住 " + targetOne.getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 等待获取 " + targetTwo.getName());
            synchronized (targetTwo) {
                System.out.println(Thread.currentThread().getName() + " 锁   住 " + targetTwo.getName());
            }
        }
    }
}
