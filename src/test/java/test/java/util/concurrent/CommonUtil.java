package test.java.util.concurrent;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
            new ThreadPoolExecutor(processorsCount,processorsCount*8,60L,
                    TimeUnit.SECONDS,new LinkedBlockingDeque<>(1024),
                    new ThreadFactoryBuilder().setNameFormat("calculateExecutor-%d").build(),
                    new ThreadPoolExecutor.AbortPolicy());
}
