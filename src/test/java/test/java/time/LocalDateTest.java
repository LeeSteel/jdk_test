package test.java.time;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

    static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void main(String[] args) {
        String beginDateStr = "20210831";
        String endDateStr = "20211001";
        System.out.println(calcMonthBetween(LocalDate.parse(beginDateStr, yyyyMMdd),
                LocalDate.parse(endDateStr, yyyyMMdd)));


    }

    @Test
    public void doTest() {
        String beginDateStr = "20200801";
        String endDateStr = "20210903";

        System.out.println(calcDaysBetween(beginDateStr, endDateStr));
        System.out.println(calcMonthBetween(beginDateStr, endDateStr));

    }

    @Test
    public void doTestDayOfWeek() {
        LocalDate localDate = LocalDate.of(2021, 6, 6);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(localDate.toString());
        System.out.println(dayOfWeek.getValue());
    }

    /**
     * 计算日期 相差多少天
     *
     * @param beginDate yyyyMMdd
     * @param endDate   yyyyMMdd
     * @return
     */
    public static int calcDaysBetween(Integer beginDate, Integer endDate) {
        LocalDate beginLocalDate = LocalDate.of(beginDate / 10000, (beginDate / 100) % 100, beginDate % 100);
        LocalDate endDateLocalDate = LocalDate.of(endDate / 10000, (endDate / 100) % 100, endDate % 100);

        return (int) (endDateLocalDate.toEpochDay() - beginLocalDate.toEpochDay());
    }


    /**
     * 计算日期 相差多少天
     *
     * @param beginDate yyyyMMdd
     * @param endDate   yyyyMMdd
     * @return
     */
    public static long calcDaysBetween(String beginDate, String endDate) {
        LocalDate beginLocalDate = LocalDate.parse(beginDate, yyyyMMdd);
        LocalDate endDateLocalDate = LocalDate.parse(endDate, yyyyMMdd);

        return ChronoUnit.DAYS.between(beginLocalDate, endDateLocalDate);
    }

    /**
     * 计算日期 相差多少月
     *
     * @param beginDate yyyyMMdd
     * @param endDate   yyyyMMdd
     * @return
     */
    public static long calcMonthBetween(String beginDate, String endDate) {
        LocalDate beginLocalDate = LocalDate.parse(beginDate, yyyyMMdd);
        LocalDate endDateLocalDate = LocalDate.parse(endDate, yyyyMMdd);

        return ChronoUnit.MONTHS.between(beginLocalDate, endDateLocalDate);
    }

    /**
     * 计算日期 相差多少月
     *
     * @param beginLocalDate
     * @param endDateLocalDate
     * @return
     */
    public static long calcMonthBetween(LocalDate beginLocalDate, LocalDate endDateLocalDate) {
        int beginYear = beginLocalDate.getYear();
        int beginMonth = beginLocalDate.getMonth().getValue();
        int beginDay = beginLocalDate.getDayOfMonth();
        long packed1 = (beginYear * 12L + beginMonth - 1) * 32L + beginDay;

        int endYear = endDateLocalDate.getYear();
        int endMonth = endDateLocalDate.getMonth().getValue();
        int endDay = endDateLocalDate.getDayOfMonth();
        long packed2 = (endYear * 12L + endMonth - 1) * 32L + endDay;
        return (packed2 - packed1) / 32L;
    }
}
