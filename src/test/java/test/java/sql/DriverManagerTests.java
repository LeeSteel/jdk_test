package test.java.sql;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/4 9:55
 * @Copyright: Copyright (c) 2019
 */
public class DriverManagerTests {

    @SneakyThrows
    @BeforeEach
    public void init() {
        // 注册日志
        DriverManager.setLogWriter(new PrintWriter(System.out));
        //注册驱动,一般放在 驱动实现类静态代码块中
       // DriverManager.registerDriver(new MyDriver());
    }

    @Test
    public void getDriversTest() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement().toString());
        }

    }
}
