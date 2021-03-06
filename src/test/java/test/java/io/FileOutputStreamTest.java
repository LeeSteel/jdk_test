package test.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/8/17 16:12
 * @Copyright: Copyright (c) 2019
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        doTest();
    }

    public static void doTest() {
        String logFileName = "d:test.txt";
        File logFile = new File(logFileName);
        String appendLog = "中文";
        try (FileOutputStream fos = new FileOutputStream(logFile, true)) {
            fos.write(appendLog.getBytes("utf-8"));
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doTestTwo() {
        String logFileName = "d:test.txt";
        File logFile = new File(logFileName);
        String appendLog = "中文";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(logFile, true);
            fos.write(appendLog.getBytes("utf-8"));
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
