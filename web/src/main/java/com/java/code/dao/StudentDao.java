package com.java.code.dao;

import com.java.code.entity.Student;
import com.java.code.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentDao
 * Package Name: com.java.code.dao
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
@Repository
public class StudentDao implements StudentDaoInterface {

    private final StudentMapper studentMapper;

    public StudentDao(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public boolean insertStudent(Student student) {
        int updatedRowNum = studentMapper.insertStudent(student);
        return updatedRowNum > 0;
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        int updatedRowNum = studentMapper.deleteStudentById(studentId);
        return updatedRowNum > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        int updatedRowNum = studentMapper.updateStudent(student);
        return updatedRowNum > 0;
    }

    @Override
    public List<Student> selectAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public Student selectStudentById(Long studentId) {
        return studentMapper.selectStudentById(studentId);
    }

}
