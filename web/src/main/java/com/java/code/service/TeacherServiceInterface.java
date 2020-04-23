package com.java.code.service;

import com.java.code.entity.Homework;
import com.java.code.entity.Student;
import com.java.code.entity.StudentHomework;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: TeacherServiceInterface
 * Package Name: com.java.code.service
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
public interface TeacherServiceInterface {

    boolean addStudent(Student student);

    List<Student> queryAllStudents();

    boolean addHomework(Homework homework);

    List<Homework> queryAllHomework();

    List<StudentHomework> queryAllSubmittedSpecifiedHomework(String specifiedHomeworkId);

}
