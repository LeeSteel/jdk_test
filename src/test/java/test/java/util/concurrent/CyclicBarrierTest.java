package test.java.util.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 测试线程栅栏 CyclicBarrier类
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/10/15 15:20
 * @Copyright: Copyright (c) 2019
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        int col = 2;
        int row = 2;
        double[][] matrix = new double[row][col];
        for (double[] items : matrix) {
            for (int i = 0; i < items.length; i++) {
                items[i] = 0.5D;
            }
        }
        Solver solver = new Solver(matrix);

    }
}

/**
 * 解决者
 */
class Solver {
    /**
     * 线程数(行数)
     */
    final int N;
    /**
     * 和
     */
    double sum;
    /**
     * 数据
     */
    final double[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;

        Worker(int row) {
            myRow = row;
        }

        public void run() {
            while (!done()) {

                processRow(myRow);
                try {
                    Thread.sleep(1000L);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException ex) {
                    return;
                }
            }
        }

        private boolean done() {
            return sum > 30;
        }

        private void processRow(int myRow) {
            double[] datum = data[myRow];
            for (int i = 0; i < datum.length; i++) {
                datum[i] = ++datum[i];
            }
            System.out.println(Arrays.toString(datum));
        }


    }

    public Solver(double[][] matrix) throws InterruptedException {
        data = matrix;
        N = matrix.length;
        Runnable barrierAction =
                () -> mergeRows(data);
        barrier = new CyclicBarrier(N, barrierAction);

        List<Thread> threads = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }

        // wait until done
        for (Thread thread : threads)
            thread.join();
    }

    private void mergeRows(double[][] data) {
        sum = Arrays.stream(Arrays.stream(data)
                .flatMapToDouble(
                        x -> Arrays.stream(x)
                ).toArray()).sum();
        System.out.println(sum);
    }
}