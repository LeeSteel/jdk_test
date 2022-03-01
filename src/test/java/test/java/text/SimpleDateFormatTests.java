package test.java.text;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/7 14:48
 * @Copyright: Copyright (c) 2019
 */
public class SimpleDateFormatTests {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadPoolExecutor poolExecutor
            = new ThreadPoolExecutor(10, 100,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000));

    /**
     * 测试 SimpleDateFormat 是否线程安全
     * 结论：线程不安全
     */
    @Test
    public void threadSafeTest() {
        int size = 10000;
        for (int i = 0; i < size; i++) {
            poolExecutor.execute(() -> {
                String newDateStr = simpleDateFormat.format(new Date());
                try {
                    Date parseDate = simpleDateFormat.parse(newDateStr);
                    String formatDateStr = simpleDateFormat.format(parseDate);
                    System.out.println("formatNewDateStr   :" + newDateStr);
                    System.out.println("formatParseDateStr :" + formatDateStr);
                    System.out.println(newDateStr.equals(formatDateStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            });
        }

    }
}
