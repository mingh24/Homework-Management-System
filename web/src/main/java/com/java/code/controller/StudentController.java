package com.java.code.controller;

import com.java.code.jdbc.StudentDatabaseManager;
import com.java.code.model.Homework;
import com.java.code.model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: StudentController
 * Package Name: com.java.code.controller
 *
 * @author yipple
 * @date 2020/3/26
 * @since 0.0.1
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentDatabaseManager.class);
    StudentDatabaseManager studentDatabaseManager = (StudentDatabaseManager) applicationContext.getBean("getStudentDatabaseManager");

    @RequestMapping(value = "/studentQueryAllHomework")
    private String studentQueryAllHomework(Model model) {
        List<Homework> homeworkList = studentDatabaseManager.queryAllHomework();
        model.addAttribute("homeworkList", homeworkList);

        return "studentQueryAllHomework.jsp";
    }

    @RequestMapping(value = "/submitHomework", method = RequestMethod.GET)
    private String submitHomeworkGet(@RequestParam(value = "specifiedHomeworkId") String specifiedHomeworkId, Model model) {
        Homework specifiedHomework = studentDatabaseManager.querySpecifiedHomework(specifiedHomeworkId);

        model.addAttribute("specifiedHomework", specifiedHomework);

        return "submitHomework.jsp";
    }

    @RequestMapping(value = "/submitHomework", method = RequestMethod.POST)
    private String submitHomeworkPost(@RequestParam(value = "studentId") String studentId, @RequestParam(value = "homeworkId") String homeworkId, @RequestParam(value = "title") String title, @RequestParam(value = "submittedContent") String submittedContent, Model model) {
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Long.valueOf(studentId));
        studentHomework.setHomeworkId(Long.valueOf(homeworkId));
        studentHomework.setHomeworkTitle(title);
        studentHomework.setHomeworkContent(submittedContent);
        studentHomework.setCreateTime(new Date());

        model.addAttribute("operation", "submitHomework");
        boolean result = studentDatabaseManager.submitStudentHomework(studentHomework);
        model.addAttribute("result", result);

        return "../result.jsp";
    }

}
