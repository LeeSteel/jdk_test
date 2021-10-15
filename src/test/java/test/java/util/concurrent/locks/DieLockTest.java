package test.java.util.concurrent.locks;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 死锁测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/11 15:19
 * @Copyright: Copyright (c) 2019
 */
public class DieLockTest {
    public static void main(String[] args) {
        DieLockTest targetOne = new DieLockTest();
        DieLockTest targetTwo = new DieLockTest();
        new Thread(() -> toLock(targetOne, targetTwo), "ThreadA").start();
        new Thread(() -> toLock(targetTwo, targetOne), "ThreadB").start();


    }

    public static void toLock(Object targetOne, Object targetTwo) {
        synchronized (targetOne) {
            System.out.println(Thread.currentThread().getName() + "锁住 targetOne");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (targetTwo) {
                System.out.println(Thread.currentThread().getName() + "锁住 targetTwo");
            }
        }
    }
}
