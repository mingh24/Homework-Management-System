package com.java.code.jdbc;

import com.java.code.model.Homework;
import com.java.code.model.Student;
import com.java.code.model.StudentHomework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Homework Management System
 * File Name: TeacherDatabaseManager
 * Package Name: com.java.code.jdbc
 *
 * @author yipple
 * @date 2020/4/6
 * @since 0.0.1
 */
@Configuration
public class TeacherDatabaseManager {

    @Bean
    public TeacherDatabaseManager getTeacherDatabaseManager() {
        return new TeacherDatabaseManager();
    }

    public boolean addStudent(Student student) {

        String sqlString = "INSERT INTO s_student(id, name, create_time) values(?, ?, ?)";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setLong(1, student.getId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setTimestamp(3, new Timestamp(student.getCreateTime().getTime()));
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;

    }

    public List<Student> queryAllStudents() {

        String sqlString = "SELECT * FROM s_student ORDER BY id, name, create_time";

        List<Student> studentList = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        Student student = new Student();
                        student.setId(resultSet.getLong("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        studentList.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;

    }

    public boolean addHomework(Homework homework) {

        String sqlString = "INSERT INTO s_homework(title, content, create_time) values(?, ?, ?)";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, homework.getTitle());
                preparedStatement.setString(2, homework.getContent());
                preparedStatement.setTimestamp(3, new Timestamp(homework.getCreateTime().getTime()));
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;

    }

    public List<Homework> queryAllHomework() {

        String sqlString = "SELECT * FROM s_homework ORDER BY id, title, content, create_time";

        List<Homework> homeworkList = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        Homework homework = new Homework();
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        homeworkList.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkList;

    }

    public List<StudentHomework> queryAllSubmittedSpecifiedHomework(String specifiedHomeworkId) {

        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id=" + specifiedHomeworkId + " ORDER BY id, student_id, homework_id, homework_title, homework_content, create_time";

        List<StudentHomework> studentHomeworkList = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        StudentHomework studentHomework = new StudentHomework();
                        studentHomework.setId(resultSet.getLong("id"));
                        studentHomework.setStudentId(resultSet.getLong("student_id"));
                        studentHomework.setHomeworkId(resultSet.getLong("homework_id"));
                        studentHomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        studentHomework.setHomeworkContent(resultSet.getString("homework_content"));
                        studentHomework.setCreateTime(resultSet.getTimestamp("create_time"));
                        studentHomeworkList.add(studentHomework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentHomeworkList;
    }

}
