package test.java.time.format;

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
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000));

    public static void main(String[] args) {

        while (true) {
            poolExecutor.execute(() -> {
                String dateString = dateTimeFormatter.format(LocalDateTime.now());
                    TemporalAccessor parseDate = dateTimeFormatter.parse(dateString);
                    String dateString2 = dateTimeFormatter.format(parseDate);
                    System.out.println(dateString.equals(dateString2));
            });
        }
    }
}
