package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/8/7 18:08
 * @Copyright: Copyright (c) 2019
 */
public class DateTests {

    @Test
    public void compareToTest(){
        Date  signupBegin = new Date(2023,9,1);
        System.out.println(new Date().compareTo(signupBegin)<0);

    }
}
