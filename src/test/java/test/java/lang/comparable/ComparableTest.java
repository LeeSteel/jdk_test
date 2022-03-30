package test.java.lang.comparable;

import org.junit.jupiter.api.Test;
import test.java.lang.comparable.domain.ComparableBean;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: Comparable 接口实现测试
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/6 11:24
 * @Copyright: Copyright (c) 2019
 */
public class ComparableTest {

    @Test
    public void main() {
        TreeMap<ComparableBean, String> treeMap = new TreeMap<>();

        initData().stream().forEach(t -> treeMap.put(t, t.getDate() + " " + t.getTime()));

        System.out.println(treeMap.size());
        System.out.println(treeMap);

    }

    public static List<ComparableBean> initData() {
        List<ComparableBean> comparableBeanList = new ArrayList<>();
        ComparableBean comparableBean = new ComparableBean();
        comparableBean.setDate(20210101);
        comparableBean.setTime(101201);
        comparableBeanList.add(comparableBean);

        comparableBean = new ComparableBean();
        comparableBean.setDate(20210201);
        comparableBean.setTime(101201);
        comparableBeanList.add(comparableBean);

        comparableBean = new ComparableBean();
        comparableBean.setDate(20210201);
        comparableBean.setTime(101211);
        comparableBeanList.add(comparableBean);
        return comparableBeanList;
    }
}
