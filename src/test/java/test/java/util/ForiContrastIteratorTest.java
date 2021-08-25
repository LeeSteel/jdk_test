package test.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: Fori 循环对比 Iterator 循环，效率对比
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/6/1 18:43
 * @Copyright: Copyright (c) 2019
 */
public class ForiContrastIteratorTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        //
        int arraySize = 100000;
        //循环次数
        int foriSize = 100;

        for (int i = 0; i < arraySize; i++) {
            arrayList.add(i);
        }
        //测试fori循环耗时
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < foriSize; j++) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i);
            }
        }
        System.out.println("fori    耗时 " + (System.currentTimeMillis() - beginTime));

        //测试Iterator循环耗时
        beginTime = System.currentTimeMillis();

        for (int j = 0; j < foriSize; j++) {
            for (Iterator i = arrayList.iterator(); i.hasNext(); ) {
                i.next();
            }
        }
        System.out.println("Iterator耗时 " + (System.currentTimeMillis() - beginTime));


        System.out.println("结论，实现RandomAccess接口的元素，通过fori循环会比Iterator循环快");
    }
}
