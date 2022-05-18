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