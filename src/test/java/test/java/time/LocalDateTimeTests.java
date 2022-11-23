package test.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author:
 * @date: 2022/11/18 15:34
 * @Copyright: Copyright (c) 2019
 */
public class LocalDateTimeTests {
    /**
     * 测试 加分钟，跨小时的时候，是否自动调整
     */
    @Test
    public void plusMinutesTest(){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.of(2022,11,18,17,50,0);
        System.out.println(pattern.format(now));
        now = now.plusMinutes(10);
        System.out.println(pattern.format(now));
    }
}
