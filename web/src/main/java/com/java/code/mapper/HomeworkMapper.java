package com.java.code.mapper;

import com.java.code.entity.Homework;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: HomeworkMapper
 * Package Name: com.java.code.mapper
 *
 * @author yipple
 * @date 2020/5/18
 * @since 0.0.1
 */
@Repository
public interface HomeworkMapper {

    int insertHomework(@Param("homework") Homework homework);

    int deleteHomeworkById(@Param("id") Long id);

    int updateHomework(@Param("homework") Homework homework);

    List<Homework> selectAllHomework();

    Homework selectHomeworkById(@Param("id") Long id);

}
