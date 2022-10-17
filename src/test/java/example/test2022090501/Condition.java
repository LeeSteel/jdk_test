package example.test2022090501;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/9/5 11:47
 * @Copyright: Copyright (c) 2019
 */
@FunctionalInterface
public interface Condition<T1,T2> {
    boolean check(T1 t1,T2 t2);
}
