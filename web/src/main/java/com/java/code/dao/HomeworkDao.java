package com.java.code.dao;

import com.java.code.entity.Homework;
import com.java.code.mapper.HomeworkMapper;
import org.springframework.stereotype.Repository;

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

    private final HomeworkMapper homeworkMapper;

    public HomeworkDao(HomeworkMapper homeworkMapper) {
        this.homeworkMapper = homeworkMapper;
    }

    @Override
    public boolean insertHomework(Homework homework) {
        int updatedRowNum = homeworkMapper.insertHomework(homework);
        return updatedRowNum > 0;
    }

    @Override
    public boolean deleteHomework(Long homeworkId) {
        int updatedRowNum = homeworkMapper.deleteHomeworkById(homeworkId);
        return updatedRowNum > 0;
    }

    @Override
    public boolean updateHomework(Homework homework) {
        int updatedRowNum = homeworkMapper.updateHomework(homework);
        return updatedRowNum > 0;
    }

    @Override
    public List<Homework> selectAllHomework() {
        return homeworkMapper.selectAllHomework();
    }

    @Override
    public Homework selectHomeworkById(Long homeworkId) {
        return homeworkMapper.selectHomeworkById(homeworkId);
    }

}
