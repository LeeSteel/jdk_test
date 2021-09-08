package test.java.lang.threadlocal;


/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/7 14:00
 * @Copyright: Copyright (c) 2019
 */
public class ThreadLocalTest1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal =new ThreadLocal<>();

        Thread threadA = new Thread(() -> {
            threadLocal.set("threadA");
            String threadName = threadLocal.get();
            System.out.println(Thread.currentThread().getName() +" get threadName:"+ threadName);
        });
        threadA.setName("threadA");
        threadA.start();

        Thread.sleep(1000L);

        Thread threadB = new Thread(() -> {
            String threadName = threadLocal.get();
            System.out.println(Thread.currentThread().getName() +" get threadName:"+ threadName);
        });
        threadB.setName("threadB");
        threadB.start();
    }
}
