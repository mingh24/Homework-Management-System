package com.java.code.dao;

import com.java.code.entity.StudentHomework;
import com.java.code.mapper.StudentHomeworkMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentHomeworkDao
 * Package Name: com.java.code.dao
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
@Repository
public class StudentHomeworkDao implements StudentHomeworkDaoInterface {

    private final StudentHomeworkMapper studentHomeworkMapper;

    public StudentHomeworkDao(StudentHomeworkMapper studentHomeworkMapper) {
        this.studentHomeworkMapper = studentHomeworkMapper;
    }

    @Override
    public boolean insertStudentHomework(StudentHomework studentHomework) {
        int updatedRowNum = studentHomeworkMapper.insertStudentHomework(studentHomework);
        return updatedRowNum > 0;
    }

    @Override
    public boolean deleteStudentHomework(Long studentHomeworkId) {
        int updatedRowNum = studentHomeworkMapper.deleteStudentHomeworkById(studentHomeworkId);
        return updatedRowNum > 0;
    }

    @Override
    public boolean updateStudentHomework(StudentHomework studentHomework) {
        int updatedRowNum = studentHomeworkMapper.updateStudentHomework(studentHomework);
        return updatedRowNum > 0;
    }

    @Override
    public List<StudentHomework> selectAllStudentHomework() {
        return studentHomeworkMapper.selectAllStudentHomework();
    }

    @Override
    public List<StudentHomework> selectAllStudentHomeworkByStudentId(Long studentId) {
        return studentHomeworkMapper.selectAllStudentHomeworkByStudentId(studentId);
    }

    @Override
    public List<StudentHomework> selectAllStudentHomeworkByHomeworkId(Long homeworkId) {
        return studentHomeworkMapper.selectAllStudentHomeworkByHomeworkId(homeworkId);
    }

    @Override
    public StudentHomework selectStudentHomeworkById(Long studentHomeworkId) {
        return studentHomeworkMapper.selectStudentHomeworkById(studentHomeworkId);
    }

}
