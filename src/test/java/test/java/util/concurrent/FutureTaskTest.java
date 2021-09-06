package test.java.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/6 13:53
 * @Copyright: Copyright (c) 2019
 */
public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException {

        List<FutureTask<Integer>> taskList = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(new ComputeTask(i + ""));
            taskList.add(futureTask);
            //提交任务到线程池
            executorService.submit(futureTask);
        }

        System.out.println("所有任务提交完毕,主线程接着执行");
        System.out.println("主线程等待中。。。");
        Thread.sleep(5000L);
        System.out.println("主线程等待完毕");
        Integer result = 0;
        for (FutureTask<Integer> futureTask : taskList) {
            try {
                result += futureTask.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        }
        //关闭线程池
        executorService.shutdown();
        System.out.println("多线程任务执行结果:" + result);
    }

    static class ComputeTask implements Callable<Integer> {
        private String taskName;

        public ComputeTask(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public Integer call() throws Exception {
            Integer result = 0;
            for (int i = 1; i <= 100; i++) {
                result += i;
            }
            System.out.println("子线程任务" + taskName + "执行完成");
            return result;
        }
    }
}
