package test.java.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: CountDownLatch 测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/15 14:49
 * @Copyright: Copyright (c) 2019
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        try {
            new Driver().main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Driver { // ...
    int N = 3;

    void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed 让所有线程继续
        doSomethingElse();
        doneSignal.await();           // wait for all to finish  等待一切结束
        doSomethingEnd();
    }

    void doSomethingElse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始工作");
        Thread.sleep(1000L);

    }

    void doSomethingEnd() {
        System.out.println("子线程执行完毕");


    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            //等待主线程方法执行完毕，释放 CountDownLatch
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        } // return;
    }

    void doWork() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始工作");
    }
}
