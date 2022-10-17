package example.test2022090501;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/9/5 11:47
 * @Copyright: Copyright (c) 2019
 */

public class FunctionTest {

    @Test
    public void test01() {
        /**
        Condition<String, ?> con = (t1, t2) -> t1.equals(t2.toString());
        con.check("t1", "t1");
        con.check("t1", 1);
        con.check("t1", new ArrayList<>());
        con.check("t1", null);
        */
    }


    @Test
    public void test02() {
        Condition<String, Object> con = (t1, t2) -> t1.equals(t2.toString());
        con.check("t1", "t1");
        con.check("t1", 1);
        con.check("t1", new ArrayList<>());
        con.check("t1", null);

    }
}
