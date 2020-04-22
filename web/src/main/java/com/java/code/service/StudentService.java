package com.java.code.service;

import com.java.code.dao.HomeworkDao;
import com.java.code.dao.StudentHomeworkDao;
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
public class StudentService {

    private HomeworkDao homeworkDao = new HomeworkDao();
    private StudentHomeworkDao studentHomeworkDao = new StudentHomeworkDao();

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
