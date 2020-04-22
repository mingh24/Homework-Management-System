package com.java.code.dao;

import com.java.code.entity.StudentHomework;
import com.java.code.jdbc.DatabasePool;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
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

    @Override
    public boolean addStudentHomework(StudentHomework studentHomework) {
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

    @Override
    public boolean deleteStudentHomework(Long studentHomeworkId) {
        String sqlString = "DELETE FROM s_student_homework WHERE id = ?";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, String.valueOf(studentHomeworkId));
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;
    }

    @Override
    public boolean updateStudentHomework(StudentHomework studentHomework) {
        String sqlString = "UPDATE s_student_homework SET homework_title = ?, homework_content = ?, create_time = ?, update_time = ? WHERE id = ?";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, studentHomework.getHomeworkTitle());
                preparedStatement.setString(2, studentHomework.getHomeworkContent());
                preparedStatement.setTimestamp(3, new Timestamp(studentHomework.getCreateTime().getTime()));
                preparedStatement.setTimestamp(4, new Timestamp(studentHomework.getUpdateTime().getTime()));
                preparedStatement.setLong(5, studentHomework.getId());
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;
    }

    @Override
    public List<StudentHomework> getAllStudentHomework() {
        String sqlString = "SELECT * FROM s_student_homework ORDER BY homework_id, student_id, homework_title, homework_content, create_time";

        List<StudentHomework> homeworkList = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        StudentHomework studentHomework = new StudentHomework();
                        studentHomework.setId(resultSet.getLong("id"));
                        studentHomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        studentHomework.setHomeworkContent(resultSet.getString("homework_content"));
                        studentHomework.setCreateTime(resultSet.getTimestamp("create_time"));
                        studentHomework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        homeworkList.add(studentHomework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkList;
    }

    @Override
    public List<StudentHomework> getAllStudentHomeworkByStudentId(Long studentId) {
        String sqlString = "SELECT * FROM s_student_homework WHERE student_id = " + studentId + " ORDER BY homework_id, student_id, homework_title, homework_content, create_time";

        List<StudentHomework> studentHomeworkList = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        StudentHomework studentHomework = new StudentHomework();
                        studentHomework.setId(resultSet.getLong("id"));
                        studentHomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        studentHomework.setHomeworkContent(resultSet.getString("homework_content"));
                        studentHomework.setCreateTime(resultSet.getTimestamp("create_time"));
                        studentHomework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        studentHomeworkList.add(studentHomework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentHomeworkList;
    }

    @Override
    public List<StudentHomework> getAllStudentHomeworkByHomeworkId(Long homeworkId) {
        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id = " + homeworkId + " ORDER BY homework_id, student_id, homework_title, homework_content, create_time";

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
                        studentHomework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        studentHomeworkList.add(studentHomework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentHomeworkList;
    }

    @Override
    public StudentHomework getStudentHomework(Long studentHomeworkId) {
        String sqlString = "SELECT * FROM s_student_homework WHERE id = " + studentHomeworkId;

        StudentHomework studentHomework = new StudentHomework();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        studentHomework.setId(resultSet.getLong("id"));
                        studentHomework.setStudentId(resultSet.getLong("student_id"));
                        studentHomework.setHomeworkId(resultSet.getLong("homework_id"));
                        studentHomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        studentHomework.setHomeworkContent(resultSet.getString("homework_content"));
                        studentHomework.setCreateTime(resultSet.getTimestamp("create_time"));
                        studentHomework.setUpdateTime(resultSet.getTimestamp("update_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentHomework;
    }

}
