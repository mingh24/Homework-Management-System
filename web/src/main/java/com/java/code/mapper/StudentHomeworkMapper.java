package com.java.code.mapper;

import com.java.code.entity.StudentHomework;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentHomeworkMapper
 * Package Name: com.java.code.mapper
 *
 * @author yipple
 * @date 2020/5/18
 * @since 0.0.1
 */
@Repository
public interface StudentHomeworkMapper {

    int insertStudentHomework(@Param("studentHomework") StudentHomework studentHomework);

    int deleteStudentHomeworkById(@Param("id") Long id);

    int updateStudentHomework(@Param("studentHomework") StudentHomework studentHomework);

    List<StudentHomework> selectAllStudentHomework();

    List<StudentHomework> selectAllStudentHomeworkByStudentId(@Param("studentId") Long studentId);

    List<StudentHomework> selectAllStudentHomeworkByHomeworkId(@Param("homeworkId") Long homeworkId);

    StudentHomework selectStudentHomeworkById(@Param("id") Long id);

}
