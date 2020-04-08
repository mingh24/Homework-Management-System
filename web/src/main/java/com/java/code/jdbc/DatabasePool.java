package com.java.code.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Project Name: Homework-Management-System
 * File Name: DatabasePool
 * Package Name: com.java.code.jdbc
 *
 * @author yipple
 * @date 2020/3/19
 * @since 0.0.1
 */
public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    private static final String DATABASE_NAME = "school";

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME + "?&useSSL=false&serverTimezone=Asia/Shanghai";

    private static final String USER_NAME = "yisql";

    private static final String PASSWORD = "Yiang2MySQL";

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public static HikariDataSource getHikariDataSource() {

        if (null != hikariDataSource)
            return hikariDataSource;

        synchronized (DatabasePool.class) {
            if (null == hikariDataSource) {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl(URL);
                hikariConfig.setUsername(USER_NAME);
                hikariConfig.setPassword(PASSWORD);
                hikariConfig.setDriverClassName(DRIVER_NAME);
                hikariDataSource = new HikariDataSource(hikariConfig);

                return hikariDataSource;
            }
        }

        return hikariDataSource;

    }

}
