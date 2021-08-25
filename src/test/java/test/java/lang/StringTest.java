package test.java.lang;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/5/17 23:12
 * @Copyright: Copyright (c) 2019
 */
public class StringTest {
    public static void main(String[] args) {
        replaseTest();
    }

    public static void replaseTest() {
        String logStr = "2021-08-18 17:15:56.221 [JAVA] [cfy_test] [fundinvest] [INFO ] [main] [] [FundInvestBasicApplication] - 字典映射文件:thinkive.enums.fundinvest-path:classpath:config/thinkive2fundinvest.xml";

        logStr = logStr.replaceAll("[(server_version=\\w+)]", "***");
        System.out.println(logStr);
    }


    public static void indexOfTest() {
        String s = "goodgoogle";
        String t = "google";


        System.out.println(s.indexOf(t));
    }

}
