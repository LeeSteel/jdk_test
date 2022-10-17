package example.test2022082301;

import org.junit.jupiter.api.Test;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author:
 * @date: 2022/8/23 10:41
 * @Copyright: Copyright (c) 2019
 */
public class Test01 {
    @Test
    public   void test01( ) {
        int a =10 ;
        System.out.println(a++ + a--);
    }

    @Test
    public void test02(){
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;
       // b3=(b1+b2);  /*语句1*/
        b6=b4+b5;    /*语句2*/
       // b8=(b1+b4);  /*语句3*/
       // b7=(b2+b5);  /*语句4*/
       // System.out.println(b3+b6);
    }
}
