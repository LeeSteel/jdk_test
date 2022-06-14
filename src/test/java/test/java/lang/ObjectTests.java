package test.java.lang;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: Object类方法 测试
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/2/21 16:16
 * @Copyright: Copyright (c) 2019
 */
public class ObjectTests implements Cloneable{
    private List<String> list = new ArrayList<>();

    /**
     * clone 方法测试
     */
    @Test
    public void cloneTest()  throws CloneNotSupportedException{
        ObjectTests a = new ObjectTests();
        List<String> aList = new ArrayList<>();
        aList.add("A");
        a.setList(aList);

        /**
         * 如果类 未实现 Cloneable 接口，调用 clone 方法时 会出现 CloneNotSupportedException 异常
         */
        ObjectTests b = (ObjectTests) a.clone();
        /**
         * Object 类的 clone方法  克隆 对象，对象的引用地址不同，
         * 对象的 引用类型属性，还是同一份，其引用地址相同，如果想不同需要 自己重写 Object.clone 方法
         */
        System.out.println(a == b);
        System.out.println(a.getList() == b.getList());
    }
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}

