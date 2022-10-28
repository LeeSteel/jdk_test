package test.java.lang.thread;


import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/4/20 17:47
 * @Copyright: Copyright (c) 2019
 */
public class ThreadTests {

    @Test
    public void joinTest(){

        Thread threadA = new Thread(new SleepRunnable(),"threadA");
        Thread threadB = new Thread(new SleepRunnable(),"threadB");
        Thread threadC = new Thread(new SleepRunnable(),"threadC");
        
        threadA.start();
        threadB.start();
        threadC.start();
        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程执行的时候，是直接调用的target(Runnable)的run方法,并不会启动子线程，所以打印的是
     * Thread-A
     * @throws InterruptedException
     */
   @Test
   public void sonThreadNameTest() throws InterruptedException {
       Thread threadA = new Thread
               (new Thread(() -> System.out.println(Thread.currentThread().getName()),
                       "Thread-B"),
                       "Thread-A");
       threadA.start();
       threadA.join();
   }
    /**
     *
     * Thread-A
     * @throws InterruptedException
     */
    @Test
    public void sonV1ThreadNameTest() throws InterruptedException {
        Thread threadA = new Thread
                (new Thread(new Thread(() -> {
                    System.out.println(Thread.currentThread().getName());
                    Thread threadD = new Thread(()->System.out.println(Thread.currentThread().getName()),"Thread-D");
                    threadD.start();
                },
                        "Thread-C"),
                        "Thread-B"),
                        "Thread-A");
        threadA.start();
        threadA.join();
    }


    @Test
    public void highThreadCpuTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(30 * 60 * 1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            thread.setName("thread-" + i);
            thread.start();
        }

        Thread highCpuThread = new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
            }
        });
        highCpuThread.setName("HighCpu");
        highCpuThread.start();
        highCpuThread.join();
    }


  class  SleepRunnable implements Runnable{

      @Override
      public void run() {
          try {
              Thread.sleep(1000L);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName()+" is runing");
      }
  }

}
