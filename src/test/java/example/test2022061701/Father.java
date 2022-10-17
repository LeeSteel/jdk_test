package example.test2022061701;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/6/17 10:28
 * @Copyright: Copyright (c) 2019
 */
public class Father {
    private String name;

    public Father() {
        System.out.println("Father constructor is run");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(this);
        System.out.println(this.getClass());
        this.name = name;

    }
}
