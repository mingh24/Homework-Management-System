package com.java.code.configuration;

import com.java.code.jdbc.StudentDatabaseManager;
import com.java.code.jdbc.TeacherDatabaseManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project Name: Homework-Management-System
 * File Name: AppConfig
 * Package Name: com.java.code.configuration
 *
 * @author yipple
 * @date 2020/4/21
 * @since 0.0.1
 */
@Configuration
public class AppConfig {

    @Bean
    public StudentDatabaseManager studentDatabaseManager() {
        return new StudentDatabaseManager();
    }

    @Bean
    public TeacherDatabaseManager teacherDatabaseManager() {
        return new TeacherDatabaseManager();
    }

}
