package example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/10 10:06
 * @Copyright: Copyright (c) 2019
 */
public class SimpleTest {
    public static void main(String[] args) {
        BigDecimal sum = BigDecimal.valueOf(1.0);
        for (; sum.doubleValue() > 0; ) {
            sum = sum.subtract(BigDecimal.valueOf(0.15015));
            //  System.out.println(sum);
        }

       // Double[] arr = new Double[]{0.333391,0.333391,0.333218};
        //  Double[] arr =  new Double[]{0.999991,0.000009};
        Double[] arr = new Double[]{0.15015, 0.15015, 0.15015, 0.15015, 0.15015, 0.15015, 0.09910};


        List<Double> list = new ArrayList<>(Arrays.asList(arr));
        final BigDecimal[] sumBig = {new BigDecimal(0)};
        list.forEach(t -> sumBig[0] = sumBig[0].add(BigDecimal.valueOf(t)));
        System.out.println(list.stream().mapToDouble(Double::doubleValue).sum());
        System.out.println(sumBig[0].doubleValue());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("原值:\t" + list.get(i) + "\t处理后值:\t" + getPercentValue(list, 1, i, 2));
        }
    }

    /**
     * 数组
     *
     * @param arr       数组
     * @param sum       总数
     * @param idx       索引
     * @param precision 精度
     * @return
     */
    public static double getPercentValue(List<Double>arr, double sum, int idx, int precision) {
        int size = arr.size();

        if ((size - 1) < idx) {
            return 0;
        }
        //求和
        if (sum <= 0) {
            for (int i = 0; i < size; i++) {
                sum += arr.get(i);
            }
        }
        //10的2次幂是100，用于计算精度。
        double digits = Math.pow(10, precision);
        //扩大比例100
        double[] votesPerQuota = new double[size];
        for (int i = 0; i < size; i++) {
            double val = arr.get(i) / sum * digits * 100;
            votesPerQuota[i] = val;
        }
        //总数,扩大比例意味的总数要扩大
        double targetSeats = digits * 100;
        //再向下取值，组成数组
        double[] seats = new double[size];
        for (int i = 0; i < votesPerQuota.length; i++) {
            seats[i] = Math.floor(votesPerQuota[i]);
        }
        //再新计算合计，用于判断与总数量是否相同,相同则占比会100%
        double currentSum = 0;
        for (int i = 0; i < seats.length; i++) {
            currentSum += seats[i];
        }
        //余数部分的数组:原先数组减去向下取值的数组,得到余数部分的数组
        double[] remainder = new double[size];
        for (int i = 0; i < seats.length; i++) {
            remainder[i] = votesPerQuota[i] - seats[i];
        }
        while (currentSum < targetSeats) {
            double max = 0;
            int maxId = 0;
            int len = 0;
            for (int i = 0; i < remainder.length; ++i) {
                if (remainder[i] > max) {
                    max = remainder[i];
                    maxId = i;
                }
            }
            //对最大项余额加1
            ++seats[maxId];
            //已经增加最大余数加1,则下次判断就可以不需要再判断这个余额数。
            remainder[maxId] = 0;
            //总的也要加1,为了判断是否总数是否相同,跳出循环。
            ++currentSum;
        }
        // 这时候的seats就会总数占比会100%
        return seats[idx] / digits;
    }

}
