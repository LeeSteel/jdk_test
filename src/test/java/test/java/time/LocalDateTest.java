package test.java.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/6/2 14:28
 * @Copyright: Copyright (c) 2019
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021,6,6);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(localDate.toString());
        System.out.println( dayOfWeek.getValue());
    }
}
