package test.java.util.stream.sorted;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/8/16 10:45
 * @Copyright: Copyright (c) 2019
 */
public class SortStrBean {
    public String field_one;
    public String field_two;

    public String getField_one() {
        return field_one;
    }

    public void setField_one(String field_one) {
        this.field_one = field_one;
    }

    public String getField_two() {
        return field_two;
    }

    public void setField_two(String field_two) {
        this.field_two = field_two;
    }

    @Override
    public String toString() {
        return "SortStrBean{" +
                "field_one='" + field_one + '\'' +
                ", field_two='" + field_two + '\'' +
                '}';
    }
}
