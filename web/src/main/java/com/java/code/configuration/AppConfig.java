package com.java.code.configuration;

import com.java.code.service.StudentService;
import com.java.code.service.TeacherService;
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
    public StudentService studentService() {
        return new StudentService();
    }

    @Bean
    public TeacherService teacherService() {
        return new TeacherService();
    }

}
