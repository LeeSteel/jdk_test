package example.test2023051001;

import java.util.UUID;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/5/10 10:45
 * @Copyright: Copyright (c) 2019
 */
public class UUIDTest {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(s);
        System.out.println(s.length());

    }
}
