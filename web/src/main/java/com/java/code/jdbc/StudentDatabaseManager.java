package com.java.code.jdbc;

import com.java.code.model.Homework;
import com.java.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentDatabaseManager
 * Package Name: com.java.code.jdbc
 *
 * @author yipple
 * @date 2020/4/6
 * @since 0.0.1
 */
public class StudentDatabaseManager {

    public boolean submitStudentHomework(StudentHomework studentHomework) {

        String sqlString = "INSERT INTO s_student_homework(student_id, homework_id, homework_title, homework_content, create_time) values(?, ?, ?, ?, ?)";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setLong(1, studentHomework.getStudentId());
                preparedStatement.setLong(2, studentHomework.getHomeworkId());
                preparedStatement.setString(3, studentHomework.getHomeworkTitle());
                preparedStatement.setString(4, studentHomework.getHomeworkContent());
                preparedStatement.setTimestamp(5, new Timestamp(studentHomework.getCreateTime().getTime()));
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

    public Homework querySpecifiedHomework(String specifiedHomeworkId) {

        String sqlString = "SELECT * FROM s_homework WHERE id=" + specifiedHomeworkId;

        Homework specifiedHomework = new Homework();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        specifiedHomework.setId(resultSet.getLong("id"));
                        specifiedHomework.setTitle(resultSet.getString("title"));
                        specifiedHomework.setContent(resultSet.getString("content"));
                        specifiedHomework.setCreateTime(resultSet.getTimestamp("create_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return specifiedHomework;

    }

}
