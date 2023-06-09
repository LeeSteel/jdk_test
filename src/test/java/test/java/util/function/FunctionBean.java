package test.java.util.function;

import lombok.Data;
import lombok.ToString;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/4 9:21
 * @Copyright: Copyright (c) 2019
 */
@Data
@ToString
public class FunctionBean {
    private int beanId;
    private String beanName;

    public FunctionBean() {
    }

    public FunctionBean(int beanId, String beanName) {
        this.beanId = beanId;
        this.beanName = beanName;
    }

    public FunctionBean(int beanId) {
        this.beanId = beanId;
    }

    public FunctionBean(String beanName) {
        this.beanName = beanName;
    }
}
