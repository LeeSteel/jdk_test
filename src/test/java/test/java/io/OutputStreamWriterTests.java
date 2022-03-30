package test.java.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/8/17 16:12
 * @Copyright: Copyright (c) 2019
 */
public class OutputStreamWriterTests {

    @Test
    public static void doTest() {
        String logFileName = "d:test.txt";
        File logFile = new File(logFileName);
        String appendLog = "中文";

        try (FileOutputStream fos = new FileOutputStream(logFile, true);
             Writer writer = new OutputStreamWriter(fos, "utf-8")) {
            writer.write(appendLog);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public static void doTestTwo() {
        String logFileName = "d:test.txt";
        File logFile = new File(logFileName);
        String appendLog = "中文";
        FileOutputStream fos = null;
        Writer writer = null;
        try {
            fos = new FileOutputStream(logFile, true);
            writer = new OutputStreamWriter(fos, "utf-8");
            writer.write(appendLog);
            writer.flush();
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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
