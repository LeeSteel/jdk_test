package example.test2022090201;

import java.util.Map;
import java.util.Properties;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/9/2 9:47
 * @Copyright: Copyright (c) 2019
 */
public class SystemTest {
    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        Properties properties = System.getProperties();

        System.out.println(envMap.values());
        System.out.println(properties.values());
    }
}
