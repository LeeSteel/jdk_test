package test.java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/18 16:32
 * @Copyright: Copyright (c) 2019
 */
public class ReentrantLockTest {


    public static void main(String[] args) {
        // doTest();
        // doTestUnFairLock();
        doTestFairLock();
    }

    public static void doTest() {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            int size = 5;
            for (int i = 0; i < size; i++) {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < size; i++) {
                reentrantLock.unlock();
            }

            System.out.println(Thread.currentThread().getName() + " do unlock");
        }, "Thread-A").start();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " do unlock");
        }, "Thread-B").start();

    }

    /**
     * 测试非公平锁
     */
    public static void doTestUnFairLock() {
        Lock lock = new ReentrantLock();
        new Thread(() -> businessMethod(lock), "线程A").start();
        new Thread(() -> businessMethod(lock), "线程B").start();
        new Thread(() -> businessMethod(lock), "线程C").start();
        new Thread(() -> businessMethod(lock), "线程D").start();
        new Thread(() -> businessMethod(lock), "线程E").start();

    }

    /**
     * 测试公平锁
     */
    public static void doTestFairLock() {
        Lock lock = new ReentrantLock(true);
        new Thread(() -> businessMethod(lock), "线程A").start();
        new Thread(() -> businessMethod(lock), "线程B").start();
        new Thread(() -> businessMethod(lock), "线程C").start();
        new Thread(() -> businessMethod(lock), "线程D").start();
        new Thread(() -> businessMethod(lock), "线程E").start();

    }

    /**
     * 模拟业务逻辑
     *
     * @param lock
     */
    public static void businessMethod(Lock lock) {
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " do unlock");
            }

        }
    }


}
