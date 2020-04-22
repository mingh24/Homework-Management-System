package com.java.code.dao;

import com.java.code.entity.Student;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentDaoInterface
 * Package Name: com.java.code.dao
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
public interface StudentDaoInterface {

    public boolean addStudent(Student student);

    public boolean deleteStudent(Long studentId);

    public boolean updateStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudent(Long studentId);

}
