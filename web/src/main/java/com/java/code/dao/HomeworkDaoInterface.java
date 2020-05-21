package com.java.code.dao;

import com.java.code.entity.Homework;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: HomeworkDaoInterface
 * Package Name: com.java.code.dao
 *
 * @author yipple
 * @date 2020/4/22
 * @since 0.0.1
 */
public interface HomeworkDaoInterface {

    public boolean insertHomework(Homework homework);

    public boolean deleteHomework(Long homeworkId);

    public boolean updateHomework(Homework homework);

    public List<Homework> selectAllHomework();

    public Homework selectHomeworkById(Long homeworkId);

}
