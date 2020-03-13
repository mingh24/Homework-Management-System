<%@ page import="com.java.code.model.Homework" %>

<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/12
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-提交作业</title>
</head>
<body>
<h1 style="text-align: center;margin-top: 100px;margin-bottom: 50px">提交作业</h1>
<div align="center">
    <form action="${pageContext.request.contextPath}/student/submitHomework" method="post">
        <table style="border-collapse:separate;border-spacing:10px 20px;">
            <% Homework homework = (Homework) request.getAttribute("specifiedHomework"); %>
            <tr>
                <th>作业编号：</th>
                <td>
                    <%=homework.getId()%>
                </td>
            </tr>
            <tr>
                <th>作业标题：</th>
                <td>
                    <%=homework.getTitle()%>
                </td>
            </tr>
            <tr>
                <th>作业内容：</th>
                <td>
                    <%=homework.getContent()%>
                </td>
            </tr>
            <tr>
                <th>作业创建时间：</th>
                <td>
                    <%= homework.getCreateTime()%>
                </td>
            </tr>
            <tr>
                <th>学号：</th>
                <td>
                    <label>
                        <input type="number" name="studentId" maxlength="20" required>
                    </label>
                </td>
            </tr>
            <tr>
                <th>提交内容：</th>
                <td>
                    <label>
                        <textarea name="submittedContent" rows="20" cols="40" required></textarea>
                    </label>
                </td>
            </tr>
        </table>
        <input type="hidden" name="homeworkId" value="<%=homework.getId()%>">
        <input type="hidden" name="title" value="<%=homework.getTitle()%>">
        <input type="reset" value="清空" style="width: 100px;margin-right: 50px">
        <input type="submit" value="提交" style="width: 100px;margin-left: 50px">
    </form>

    <p style="text-align: center;margin-top: 50px"><a href="studentHome.jsp">返回首页</a></p>
</div>
</body>

</html>
