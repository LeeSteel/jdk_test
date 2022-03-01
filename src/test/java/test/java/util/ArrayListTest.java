package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/4/30 17:44
 * @Copyright: Copyright (c) 2019
 */
public class ArrayListTest {

    @Test
    public void doTestRemoveIndex() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (int li = 0; li < list.size(); li++) {
            list.remove(li);
        }
        System.out.println(list);
    }

    /**
     * 测试 指定初始化容量，添加到指定下标中
     */
    @Test
    public void doTestIndexAdd() {
        ArrayList list = new ArrayList(4);
        Object obj1 = new Object();
        list.add(1, obj1);

        System.out.println(list);
    }

}
