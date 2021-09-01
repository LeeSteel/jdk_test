package test.java.util.concurrent;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/8/25 17:23
 * @Copyright: Copyright (c) 2019
 */
public class CommonUtil {
    //获取CPU 核数
    private static int processorsCount = (Runtime.getRuntime() != null && Runtime.getRuntime().availableProcessors() > 0) ?
            Runtime.getRuntime().availableProcessors() : 8;

    //创建线程池
    private static final ExecutorService executorService =
            new ThreadPoolExecutor(processorsCount, processorsCount * 8, 60L,
                    TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024),
                    new ThreadFactoryBuilder().setNameFormat("calculateExecutor-%d").build(),
                    new ThreadPoolExecutor.AbortPolicy());


    public static List<CompletableFuture<Double>> calcIntervalRateOfReturn(List<Double> rawList, int scale) {
        if (rawList == null || rawList.isEmpty()) {
            return null;
        }
        if (scale < 0) {
            scale = 2;
        }
        //区间初始节点累计收益率
        Double rawStart = rawList.get(0);
        int finalScale = scale;

        //返回future返回结果到list
        return rawList.stream().map(t -> CompletableFuture.supplyAsync(() -> calculate(rawStart, t, finalScale), executorService)).collect(Collectors.toList());

    }

    private static double calculate(double rawStart, Double rawElement, int scale) {
        try {
            BigDecimal startBigDecimal = new BigDecimal(Double.toString(rawStart));
            BigDecimal elementBigDecimal = new BigDecimal(Double.toString(rawElement));

            BigDecimal elementAdd = elementBigDecimal.add(BigDecimal.ONE);
            BigDecimal startAdd = startBigDecimal.add(BigDecimal.ONE);

            BigDecimal calData = elementAdd.divide(startAdd, 6, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE);

            //右移2位，相当于乘以100
            BigDecimal multiply = calData.movePointRight(2);
            return multiply.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }


    public static void main(String[] args) {
        int size = 1000;

        long startTimeMills = System.currentTimeMillis();
        ExecutorService executorService =
                new ThreadPoolExecutor(processorsCount, processorsCount * 8, 60L,
                        TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024),
                        new ThreadFactoryBuilder().setNameFormat("test-%d").build(),
                        new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 1000; i++) {
            List<Double> doubleList = initData(size);
            executorService.execute(() -> {
                List<CompletableFuture<Double>> completableFutures = CommonUtil.calcIntervalRateOfReturn(doubleList, 2);
                List<Double> collect = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
                System.out.println("Thread-Name:"+Thread.currentThread().getName());
            });

        }
      //  executorService.shutdown();
        long endTimeMills = System.currentTimeMillis();
        System.out.println(endTimeMills - startTimeMills);
      //  executorService.shutdown();
        while (true){

        }
    }

    public static void calcIntervalRateOfReturnTest() {
        List<Double> collect1 = Stream.of(-0.001471, 0.005247, 0.005697, 0.010783, 0.00939, 0.012461, 0.012447,
                0.012934, 0.013866, 0.014322, 0.015805, 0.015596, 0.014346, 0.009928).collect(Collectors.toList());
        List<Double> collect2 = Stream.of(-0.001471, 0.005247, 0.005697, 0.010783, 0.00939, 0.012461, 0.012447,
                0.012934, 0.013866, 0.014322, 0.015805, 0.015596, 0.014346, 0.009928).collect(Collectors.toList());
        List<CompletableFuture<Double>> completableFutures = calcIntervalRateOfReturn(collect1, 2);
        System.out.println("main线程---1");
        List<Double> collect3 = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        collect3.forEach(System.out::println);
        System.out.println("main线程---1 --计算完毕");


        List<CompletableFuture<Double>> completableFutures1 =
                calcIntervalRateOfReturn(collect2, 2);
        System.out.println("main线程---2");
        List<Double> collect4 = completableFutures1.stream().map(CompletableFuture::join).collect(Collectors.toList());
        collect4.forEach(System.out::println);
        System.out.println("main线程---2 --计算完毕");

        executorService.shutdown();
    }


    public static List<Double> initData(int size) {
        List<Double> doubleList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Random random = new Random();
            double nextDouble = random.nextDouble();
            doubleList.add(nextDouble);
        }
        return doubleList;
    }
}
