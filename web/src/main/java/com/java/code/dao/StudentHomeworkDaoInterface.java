package com.java.code.dao;

import com.java.code.entity.StudentHomework;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentHomeworkDaoInterface
 * Package Name: com.java.code.dao
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
public interface StudentHomeworkDaoInterface {

    public boolean addStudentHomework(StudentHomework studentHomework);

    public boolean deleteStudentHomework(Long studentHomeworkId);

    public boolean updateStudentHomework(StudentHomework studentHomework);

    public List<StudentHomework> getAllStudentHomework();

    public List<StudentHomework> getAllStudentHomeworkByStudentId(Long studentId);

    public List<StudentHomework> getAllStudentHomeworkByHomeworkId(Long homeworkId);

    public StudentHomework getStudentHomework(Long studentHomeworkId);

}
