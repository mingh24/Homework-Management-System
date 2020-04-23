package com.java.code.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Project Name: Homework-Management-System
 * File Name: DatabasePool
 * Package Name: com.java.code.jdbc
 *
 * @author yipple
 * @date 2020/3/19
 * @since 0.0.1
 */
@Component
public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    private static String url;

    private static String userName;

    private static String password;

    private static String driverName;

    static {
        try {
            readProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readProperties() throws IOException {
        InputStream inputStream = DatabasePool.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        url = properties.getProperty("url");
        userName = properties.getProperty("user_name");
        password = properties.getProperty("password");
        driverName = properties.getProperty("driver_name");
    }

    @Bean("hikariDatasource")
    public static HikariDataSource getHikariDataSource() {
        if (null != hikariDataSource) {
            return hikariDataSource;
        }

        synchronized (DatabasePool.class) {
            if (null == hikariDataSource) {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl(url);
                hikariConfig.setUsername(userName);
                hikariConfig.setPassword(password);
                hikariConfig.setDriverClassName(driverName);
                hikariDataSource = new HikariDataSource(hikariConfig);

                return hikariDataSource;
            }
        }

        return hikariDataSource;
    }

}
