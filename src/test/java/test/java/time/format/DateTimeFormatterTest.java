package test.java.time.format;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/7 15:04
 * @Copyright: Copyright (c) 2019
 */
public class DateTimeFormatterTest {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static ThreadPoolExecutor poolExecutor
            = new ThreadPoolExecutor(10, 100,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(20000));

    /**
     * 测试 DateTimeFormatter 是否线程安全
     * 结论：线程安全
     */
    @Test
    public void threadSafeTest() {
        int size = 10000;
        for (int i = 0; i < size; i++) {
            poolExecutor.execute(() -> {
                String formatLocalDateTimeStr = dateTimeFormatter.format(LocalDateTime.now());
                TemporalAccessor parseDate = dateTimeFormatter.parse(formatLocalDateTimeStr);
                String formatTemporalAccessorStr = dateTimeFormatter.format(parseDate);
                System.out.println("formatLocalDateTimeStr   :" + formatLocalDateTimeStr);
                System.out.println("formatTemporalAccessorStr:" + formatTemporalAccessorStr);

                System.out.println(formatLocalDateTimeStr.equals(formatTemporalAccessorStr));
            });
        }
    }
}

