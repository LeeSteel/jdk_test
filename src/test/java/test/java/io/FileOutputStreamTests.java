package test.java.io;

import org.junit.jupiter.api.Test;

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
public class FileOutputStreamTests {
    /**
     *  测试 tryResources 中关闭  FileOutputStream
     */
    @Test
    public void tryResourcesCloseTest() {
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

    /**
     *  测试 tryCatch 中关闭  FileOutputStream
     */
    @Test
    public void tryCatchCloseTest() {
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
