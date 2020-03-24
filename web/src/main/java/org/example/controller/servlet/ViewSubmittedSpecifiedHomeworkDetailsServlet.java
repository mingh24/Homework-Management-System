package org.example.controller.servlet;

import com.java.code.jdbc.DatabaseManager;
import com.java.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Project Name: Homework Management System
 * File Name: ViewSubmittedHomeworkDetails
 * Package Name: com.java.code.servlet
 *
 * @author yipple
 * @date 2020/3/13
 * @since 0.0.1
 */
@WebServlet("/teacher/viewSubmittedSpecifiedHomeworkDetails")
public class ViewSubmittedSpecifiedHomeworkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容编码，防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String specifiedHomeworkId = req.getParameter("specifiedHomeworkId");

        List<StudentHomework> submittedSpecifiedHomework = DatabaseManager.queryAllSubmittedSpecifiedHomework(specifiedHomeworkId);
        req.setAttribute("submittedSpecifiedHomework", submittedSpecifiedHomework);
        req.getRequestDispatcher("viewSubmittedSpecifiedHomeworkDetails.jsp").forward(req, resp);
    }
}
