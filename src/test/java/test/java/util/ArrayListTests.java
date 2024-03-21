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
public class ArrayListTests {

    @Test
    public void removeIndexTest() {
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
    public void initAndIndexAdd() {
        ArrayList list = new ArrayList(4);

        list.add(1,  new Object());

        System.out.println(list);
    }

    @Test
    public void addNull(){
        ArrayList list = new ArrayList(4);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    @Test
    public void nullForEach(){
        ArrayList list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        list.stream().forEach(System.out::println);
        list.stream().forEach(item -> {
            System.out.println(item);
        });

    }


}
