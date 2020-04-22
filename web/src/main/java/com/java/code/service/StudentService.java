package com.java.code.service;

import com.java.code.dao.HomeworkDaoInterface;
import com.java.code.dao.StudentHomeworkDaoInterface;
import com.java.code.entity.Homework;
import com.java.code.entity.StudentHomework;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentService
 * Package Name: com.java.code.service
 *
 * @author yipple
 * @date 2020/4/6
 * @since 0.0.1
 */
@Service
public class StudentService {

    private final HomeworkDaoInterface homeworkDao;

    private final StudentHomeworkDaoInterface studentHomeworkDao;

    public StudentService(HomeworkDaoInterface homeworkDao, StudentHomeworkDaoInterface studentHomeworkDao) {
        this.homeworkDao = homeworkDao;
        this.studentHomeworkDao = studentHomeworkDao;
    }

    public boolean submitStudentHomework(StudentHomework studentHomework) {
        return studentHomeworkDao.addStudentHomework(studentHomework);
    }

    public List<Homework> queryAllHomework() {
        return homeworkDao.getAllHomework();
    }

    public Homework querySpecifiedHomework(String specifiedHomeworkId) {
        return homeworkDao.getHomework(Long.valueOf(specifiedHomeworkId));
    }

}
