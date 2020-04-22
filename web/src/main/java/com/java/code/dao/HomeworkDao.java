package com.java.code.dao;

import com.java.code.entity.Homework;
import com.java.code.jdbc.DatabasePool;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: HomeworkDao
 * Package Name: com.java.code.dao
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
@Repository
public class HomeworkDao implements HomeworkDaoInterface {

    @Override
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

    @Override
    public boolean deleteHomework(Long homeworkId) {
        String sqlString = "DELETE FROM s_homework WHERE id = ?";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, String.valueOf(homeworkId));
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;
    }

    @Override
    public boolean updateHomework(Homework homework) {
        String sqlString = "UPDATE s_homework SET title = ?, content = ?, create_time = ?, update_time = ? WHERE id = ?";

        int updatedRowNum = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, homework.getTitle());
                preparedStatement.setString(2, homework.getContent());
                preparedStatement.setTimestamp(3, new Timestamp(homework.getCreateTime().getTime()));
                preparedStatement.setTimestamp(4, new Timestamp(homework.getUpdateTime().getTime()));
                preparedStatement.setLong(5, homework.getId());
                updatedRowNum = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedRowNum > 0;
    }

    @Override
    public List<Homework> getAllHomework() {
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
                        homework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        homeworkList.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkList;
    }

    @Override
    public Homework getHomework(Long homeworkId) {
        String sqlString = "SELECT * FROM s_homework WHERE id = " + homeworkId;

        Homework homework = new Homework();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        homework.setUpdateTime(resultSet.getTimestamp("update_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homework;
    }

}
