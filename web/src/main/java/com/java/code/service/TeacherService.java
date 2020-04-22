package com.java.code.service;

import com.java.code.dao.HomeworkDao;
import com.java.code.dao.StudentDao;
import com.java.code.dao.StudentHomeworkDao;
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
public class TeacherService {

    private HomeworkDao homeworkDao = new HomeworkDao();
    private StudentDao studentDao = new StudentDao();
    private StudentHomeworkDao studentHomeworkDao = new StudentHomeworkDao();

    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public List<Student> queryAllStudents() {
        return studentDao.getAllStudents();
    }

    public boolean addHomework(Homework homework) {
        return homeworkDao.addHomework(homework);
    }

    public List<Homework> queryAllHomework() {
        return homeworkDao.getAllHomework();
    }

    public List<StudentHomework> queryAllSubmittedSpecifiedHomework(String specifiedHomeworkId) {
        return studentHomeworkDao.getAllStudentHomeworkByHomeworkId(Long.valueOf(specifiedHomeworkId));
    }

}
