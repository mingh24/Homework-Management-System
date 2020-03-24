package com.java.code.jdbc;

import com.java.code.model.Homework;
import com.java.code.model.Student;
import com.java.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Homework Management System
 * File Name: DatabaseManager
 * Package Name: com.java.code.com.java.code.jdbc
 *
 * @author yipple
 * @date 2020/3/12
 * @since 0.0.1
 */
public class DatabaseManager {

    private static final String DATABASE_NAME = "school";

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME + "?&useSSL=false&serverTimezone=Asia/Shanghai";

    private static final String USER = "yisql";

    private static final String PASSWORD = "Yiang2MySQL";

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    private static void loadDriver() {

        try {
            // 加载驱动
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static boolean addStudent(Student student) {

        String sqlString = "INSERT INTO s_student(id, name, create_time) values(?, ?, ?)";

        loadDriver();

        int updatedRowNum = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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

    public static List<Student> queryAllStudents() {

        String sqlString = "SELECT * FROM s_student ORDER BY id, name, create_time";

        loadDriver();

        List<Student> studentList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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

    public static boolean addHomework(Homework homework) {

        String sqlString = "INSERT INTO s_homework(title, content, create_time) values(?, ?, ?)";

        loadDriver();

        int updatedRowNum = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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

    public static boolean submitStudentHomework(StudentHomework studentHomework) {

        String sqlString = "INSERT INTO s_student_homework(student_id, homework_id, homework_title, homework_content, create_time) values(?, ?, ?, ?, ?)";

        loadDriver();

        int updatedRowNum = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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

    public static List<Homework> queryAllHomework() {

        String sqlString = "SELECT * FROM s_homework ORDER BY id, title, content, create_time";

        loadDriver();

        List<Homework> homeworkList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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

    public static Homework querySpecifiedHomework(String specifiedHomeworkId) {

        String sqlString = "SELECT * FROM s_homework WHERE id=" + specifiedHomeworkId;

        loadDriver();

        Homework specifiedHomework = new Homework();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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

    public static List<StudentHomework> queryAllSubmittedSpecifiedHomework(String specifiedHomeworkId) {

        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id=" + specifiedHomeworkId + " ORDER BY id, student_id, homework_id, homework_title, homework_content, create_time";

        loadDriver();

        List<StudentHomework> studentHomeworkList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
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
