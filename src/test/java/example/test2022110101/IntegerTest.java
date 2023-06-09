package example.test2022110101;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/1 16:17
 * @Copyright: Copyright (c) 2019
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        Integer e = new Integer(20);
        Integer f = new Integer(20);
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(e.equals(f));
    }
}
