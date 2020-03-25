package com.java.code.model;

import java.util.Date;

/**
 * Project Name: Homework Management System
 * File Name: Homework
 * Package Name: com.java.code.model
 *
 * @author yipple
 * @date 2020/3/12
 * @since 0.0.1
 */
public class Homework {

    private Long id;

    private String title;

    private String content;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
