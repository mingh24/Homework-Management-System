package com.java.code.controller;

import com.java.code.jdbc.DatabaseManager;
import com.java.code.model.Homework;
import com.java.code.model.Student;
import com.java.code.model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Project Name: Homework-Management-System
 * File Name: TeacherController
 * Package Name: com.java.code.controller
 *
 * @author yipple
 * @date 2020/3/26
 * @since 0.0.1
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    private String addStudent(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name, Model model) {
        Student student = new Student();
        student.setId(Long.parseLong(id));
        student.setName(name);
        student.setCreateTime(new Date());

        model.addAttribute("operation", "addStudent");
        boolean result = DatabaseManager.addStudent(student);
        model.addAttribute("result", result);

        return "../result.jsp";
    }

    @RequestMapping(value = "/queryAllStudents")
    private String queryAllStudents(Model model) {
        List<Student> studentList = DatabaseManager.queryAllStudents();
        model.addAttribute("studentList", studentList);

        return "queryAllStudents.jsp";
    }

    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    private String addHomework(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content, Model model) {
        Homework homework = new Homework();
        homework.setTitle(title);
        homework.setContent(content);
        homework.setCreateTime(new Date());

        model.addAttribute("operation", "addHomework");
        boolean result = DatabaseManager.addHomework(homework);
        model.addAttribute("result", result);

        return "../result.jsp";
    }

    @RequestMapping(value = "/teacherQueryAllHomework")
    private String teacherQueryAllHomework(Model model) {
        List<Homework> homeworkList = DatabaseManager.queryAllHomework();
        model.addAttribute("homeworkList", homeworkList);

        return "teacherQueryAllHomework.jsp";
    }

    @RequestMapping(value = "/viewSubmittedSpecifiedHomeworkDetails")
    private String viewSubmittedSpecifiedHomeworkDetails(@RequestParam(value = "specifiedHomeworkId") String specifiedHomeworkId, Model model) {
        List<StudentHomework> submittedSpecifiedHomework = DatabaseManager.queryAllSubmittedSpecifiedHomework(specifiedHomeworkId);
        model.addAttribute("submittedSpecifiedHomework", submittedSpecifiedHomework);

        return "viewSubmittedSpecifiedHomeworkDetails.jsp";
    }

}
