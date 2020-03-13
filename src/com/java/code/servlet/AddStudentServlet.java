package com.java.code.servlet;

import com.java.code.jdbc.DatabaseManager;
import com.java.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Project Name: Homework Management System
 * File Name: AddStudentServlet
 * Package Name: com.java.code.servlet
 *
 * @author yipple
 * @date 2020/3/12
 * @since 0.0.1
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容编码，防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Student student = new Student();
        student.setId(Long.parseLong(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setCreateTime(new Date());

        req.setAttribute("operation", "addStudent");
        boolean result = DatabaseManager.addStudent(student);
        req.setAttribute("result", result);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
