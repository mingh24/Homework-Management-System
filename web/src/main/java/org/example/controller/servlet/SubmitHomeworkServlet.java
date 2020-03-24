package org.example.controller.servlet;

import com.java.code.jdbc.DatabaseManager;
import com.java.code.model.Homework;
import com.java.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Project Name: Homework Management System
 * File Name: SubmitHomeworkServlet
 * Package Name: com.java.code.servlet
 *
 * @author yipple
 * @date 2020/3/12
 * @since 0.0.1
 */
@WebServlet("/student/submitHomework")
public class SubmitHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容编码，防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String specifiedHomeworkId = req.getParameter("specifiedHomeworkId");

        Homework specifiedHomework = DatabaseManager.querySpecifiedHomework(specifiedHomeworkId);
        req.setAttribute("specifiedHomework", specifiedHomework);
        req.getRequestDispatcher("submitHomework.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容编码，防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Long.valueOf(req.getParameter("studentId")));
        studentHomework.setHomeworkId(Long.valueOf(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("submittedContent"));
        studentHomework.setCreateTime(new Date());

        req.setAttribute("operation", "submitHomework");
        boolean result = DatabaseManager.submitStudentHomework(studentHomework);
        req.setAttribute("result", result);
        req.getRequestDispatcher("../result.jsp").forward(req, resp);
    }
}
