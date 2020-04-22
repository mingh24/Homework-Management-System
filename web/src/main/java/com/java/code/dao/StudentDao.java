package com.java.code.dao;

import com.java.code.entity.Student;
import com.java.code.jdbc.DatabasePool;

import java.sql.*;
import java.util.ArrayList;
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
public class StudentDao implements StudentDaoInterface {

    @Override
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

    @Override
    public boolean deleteStudent(Long studentId) {
        String sqlString = "DELETE FROM s_student WHERE id = ?";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, String.valueOf(studentId));
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        String sqlString = "UPDATE s_student SET name = ?, create_time = ?, update_time = ? WHERE id = ?";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setTimestamp(2, new Timestamp(student.getCreateTime().getTime()));
                preparedStatement.setTimestamp(3, new Timestamp(student.getUpdateTime().getTime()));
                preparedStatement.setLong(4, student.getId());
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;
    }

    @Override
    public List<Student> getAllStudents() {
        String sqlString = "SELECT * FROM s_student ORDER BY id, name, create_time, update_time";

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
                        student.setUpdateTime(resultSet.getTimestamp("update_time"));
                        studentList.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student getStudent(Long studentId) {
        String sqlString = "SELECT * FROM s_student WHERE id = " + studentId;

        Student student = new Student();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        student.setId(resultSet.getLong("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        student.setUpdateTime(resultSet.getTimestamp("update_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

}
