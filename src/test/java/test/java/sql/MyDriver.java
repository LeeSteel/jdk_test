package test.java.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 原理参考:
 * https://blog.csdn.net/MinggeQingchun/article/details/125768259
 *
 * @version V1.0
 * @Title:
 * @Package
 * @Description:  自定义 jdbc 驱动
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/4 10:01
 * @Copyright: Copyright (c) 2019
 */
public class MyDriver implements Driver {
    static {
        //注册驱动,一般放在 驱动实现类静态代码块中
        try {
            DriverManager.registerDriver(new MyDriver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
