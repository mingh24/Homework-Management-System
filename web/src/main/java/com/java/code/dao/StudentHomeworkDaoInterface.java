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

    public boolean insertStudentHomework(StudentHomework studentHomework);

    public boolean deleteStudentHomework(Long studentHomeworkId);

    public boolean updateStudentHomework(StudentHomework studentHomework);

    public List<StudentHomework> selectAllStudentHomework();

    public List<StudentHomework> selectAllStudentHomeworkByStudentId(Long studentId);

    public List<StudentHomework> selectAllStudentHomeworkByHomeworkId(Long homeworkId);

    public StudentHomework selectStudentHomeworkById(Long studentHomeworkId);

}
