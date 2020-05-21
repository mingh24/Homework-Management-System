package com.java.code.service;

import com.java.code.dao.*;
import com.java.code.entity.Homework;
import com.java.code.entity.Student;
import com.java.code.entity.StudentHomework;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name: Homework Management System
 * File Name: TeacherService
 * Package Name: com.java.code.service
 *
 * @author yipple
 * @date 2020/4/6
 * @since 0.0.1
 */
@Service
public class TeacherService implements TeacherServiceInterface {

    private final HomeworkDaoInterface homeworkDao;

    private final StudentDaoInterface studentDao;

    private final StudentHomeworkDaoInterface studentHomeworkDao;

    public TeacherService(HomeworkDaoInterface homeworkDao, StudentDaoInterface studentDao, StudentHomeworkDaoInterface studentHomeworkDao) {
        this.homeworkDao = homeworkDao;
        this.studentDao = studentDao;
        this.studentHomeworkDao = studentHomeworkDao;
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryAllStudents() {
        return studentDao.selectAllStudents();
    }

    @Override
    public boolean addHomework(Homework homework) {
        return homeworkDao.insertHomework(homework);
    }

    @Override
    public List<Homework> queryAllHomework() {
        return homeworkDao.selectAllHomework();
    }

    @Override
    public List<StudentHomework> queryAllSubmittedSpecifiedHomework(String specifiedHomeworkId) {
        return studentHomeworkDao.selectAllStudentHomeworkByHomeworkId(Long.valueOf(specifiedHomeworkId));
    }

}
