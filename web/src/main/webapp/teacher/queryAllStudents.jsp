<%@ page import="com.java.code.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.DatabaseManager" %>

<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/12
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-学生列表</title>
</head>

<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#63B8FF" height="50">
        <td>学生学号</td>
        <td>学生姓名</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("studentList");
        if (null == studentList || studentList.size() <= 0) {
    %>
    <p style="text-align: center">无相关记录</p>
    <%
    } else {
        for (Student student : studentList) {
    %>
    <tr align="center" bgcolor="white" height="30">
        <td>
            <%=student.getId()%>
        </td>
        <td>
            <%=student.getName()%>
        </td>
        <td>
            <%=student.getCreateTime()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<p style="text-align: center;margin-top: 50px"><a href="teacherHome.jsp">返回首页</a></p>
</body>

</html>