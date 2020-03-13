<%@ page import="com.java.code.model.StudentHomework" %>
<%@ page import="com.java.code.jdbc.DatabaseManager" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/12
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-作业提交详情</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#63B8FF" height="50">
        <td>ID</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<StudentHomework> submittedSpecifiedHomework = (List<StudentHomework>) request.getAttribute("submittedSpecifiedHomework");
        if (null == submittedSpecifiedHomework || submittedSpecifiedHomework.size() <= 0) {
    %>
    <p style="text-align: center">无相关记录</p>
    <%
    } else {
        for (StudentHomework studentHomework : submittedSpecifiedHomework) {
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=studentHomework.getId()%>
        </td>
        <td><%=studentHomework.getStudentId()%>
        </td>
        <td><%=studentHomework.getHomeworkId()%>
        </td>
        <td><%=studentHomework.getHomeworkTitle()%>
        </td>
        <td><%=studentHomework.getHomeworkContent()%>
        </td>
        <td><%=studentHomework.getCreateTime()%>
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
