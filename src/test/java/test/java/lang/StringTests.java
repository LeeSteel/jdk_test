package test.java.lang;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/5/17 23:12
 * @Copyright: Copyright (c) 2019
 */
public class StringTests {

    @Test
    public  void replaseAllTest() {
        String logStr = "2021-08-18 17:15:56.221 [JAVA] [cfy_test] [fundinvest] [INFO ] [main] [] [FundInvestBasicApplication] - 字典映射文件:thinkive.enums.fundinvest-path:classpath:config/thinkive2fundinvest.xml";
        logStr = logStr.replaceAll("[(server_version=\\w+)]", "***");
        System.out.println(logStr);
    }
    @Test
    public  void replaseTest() {
        String logStr = "李某某";

        System.out.println(logStr);
    }

    @Test
    public void indexOfTest() {
        String s = "goodgoogle";
        String t = "google";
        System.out.println(s.indexOf(t));
    }
    @Test
    public void formatTest() {
        String s = "123";
        System.out.println(String.format("%-4s",s));
    }

}
