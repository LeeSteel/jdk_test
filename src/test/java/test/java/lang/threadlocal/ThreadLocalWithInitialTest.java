package test.java.lang.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/7 13:21
 * @Copyright: Copyright (c) 2019
 */
public class ThreadLocalWithInitialTest {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));



    public static ExecutorService threadPool = new ThreadPoolExecutor(16, 16,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String data = new ThreadLocalWithInitialTest().formatDate(finalI);
                System.out.println(Thread.currentThread().getName() + " " + data);
            });
             Thread.sleep(10);
        }
        threadPool.shutdown();
    }

    /**
     * 格式化 时间
     * @param seconds 秒数
     * @return mm:ss 格式的时间
     */
    private String formatDate(int seconds) {
        Date date = new Date(1000 * seconds);
        //  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
       SimpleDateFormat simpleDateFormat = dateFormatThreadLocal.get();
        //  SimpleDateFormat simpleDateFormat = sdf;
        System.out.println(simpleDateFormat);
        return simpleDateFormat.format(date);
    }

}
