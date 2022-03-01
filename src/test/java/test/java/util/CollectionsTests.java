package test.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/2/23 16:06
 * @Copyright: Copyright (c) 2019
 */
public class CollectionsTests {
    /**
     * 集合工具类 混淆 shuffle 测试
     */
    @Test
    public void shuffleTest() {
        List<String> list = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            list.add("" + i);
        }
        for (int i = 0; i < size; i++) {
            Collections.shuffle(list);
            System.out.println(list.toString());
        }
    }
}
