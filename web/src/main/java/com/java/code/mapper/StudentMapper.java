package com.java.code.mapper;

import com.java.code.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentMapper
 * Package Name: com.java.code.mapper
 *
 * @author yipple
 * @date 2020/5/18
 * @since 0.0.1
 */
@Repository
public interface StudentMapper {

    int insertStudent(@Param("student") Student student);

    int deleteStudentById(@Param("id") Long id);

    int updateStudent(@Param("student") Student student);

    List<Student> selectAllStudents();

    Student selectStudentById(@Param("id") Long id);

}
