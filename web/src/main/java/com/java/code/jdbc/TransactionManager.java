package com.java.code.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Project Name: Homework-Management-System
 * File Name: TransactionManager
 * Package Name: com.java.code.jdbc
 *
 * @author yipple
 * @date 2020/4/23
 * @since 0.0.1
 */
@Component
public class TransactionManager {

    private final HikariDataSource hikariDataSource;

    public TransactionManager(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    public void beginTransaction() {
        try {
            hikariDataSource.getConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            hikariDataSource.getConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            hikariDataSource.getConnection().rollback();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
