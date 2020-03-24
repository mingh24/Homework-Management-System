package com.java.code.model;

import java.util.Date;

/**
 * Project Name: Homework Management System
 * File Name: Student
 * Package Name: com.java.code.com.java.code.model
 *
 * @author yipple
 * @date 2020/3/12
 * @since 0.0.1
 */
public class Student {

    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
