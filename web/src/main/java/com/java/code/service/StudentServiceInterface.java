package com.java.code.service;

import com.java.code.entity.Homework;
import com.java.code.entity.StudentHomework;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentServiceInterface
 * Package Name: com.java.code.service
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
public interface StudentServiceInterface {

    boolean submitStudentHomework(StudentHomework studentHomework);

    List<Homework> queryAllHomework();

    Homework querySpecifiedHomework(String specifiedHomeworkId);
}
