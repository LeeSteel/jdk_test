package test.java.lang.reflect.domain;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/1 11:20
 * @Copyright: Copyright (c) 2019
 */
public class ReflexTestFatherBean {

    private String fatherName;

    public void method() {
        System.out.println("father    method  is run");
    }

    private void fatherPriMethod() {
        System.out.println("father  private  method  is run");
    }

    public static void fatherPubStaMethod() {
        System.out.println("father  public static  method  is run");
    }

    public void fatherPubMethod() {
        System.out.println("father  public  method  is run");
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

}
