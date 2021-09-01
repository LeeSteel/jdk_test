package test.java.lang.reflect.domain;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/1 11:18
 * @Copyright: Copyright (c) 2019
 */
public class ReflexTestSonBean extends  ReflexTestFatherBean{
    private String sonName;

    @Override
    public void method() {
        System.out.println("son  method  is run");
    }
    private void sonPriMethod() {
        System.out.println("son  private  method  is run");
    }

    public static void sonPubStaMethod() {
        System.out.println("son  public static  method  is run");
    }

    public void sonPubMethod() {
        System.out.println("son  public  method  is run");
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

}
