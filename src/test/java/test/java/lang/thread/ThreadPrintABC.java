package test.java.lang.thread;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/4/21 14:42
 * @Copyright: Copyright (c) 2019
 */
public class ThreadPrintABC {
    //锁住的对象
    private final static Object lock = new Object();
    //A是否已经执行
    private static boolean aExecuted = false;
    //B是否已经执行过
    private static boolean bExecuted = false;

    public static void printA() {
        synchronized (lock) {
            System.out.println("A");
            aExecuted = true;
            //唤醒所有等待线程
            lock.notifyAll();
        }
    }

    public static void printB() throws InterruptedException {
        synchronized (lock) {
            //获取到锁，但是要等A执行
            while (!aExecuted) {
                lock.wait();
            }
            System.out.println("B");
            bExecuted = true;
            lock.notifyAll();
        }
    }

    public static void printC() throws InterruptedException {
        synchronized (lock) {
            //获取到锁，但是要等B执行
            while (!bExecuted) {
                lock.wait();
            }
            System.out.println("C");
        }
    }

    @Test
    void printlnABC() {
        //线程A
        new Thread(() -> {
            ThreadPrintABC.printA();
        }, "A").start();
        //线程B
        new Thread(() -> {
            try {
                ThreadPrintABC.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        //线程C
        new Thread(() -> {
            try {
                ThreadPrintABC.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}
