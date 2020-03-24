<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/12
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-操作结果</title>
</head>

<body>
<%
    String operation = (String) request.getAttribute("operation");
    boolean result = (boolean) request.getAttribute("result");
    switch (operation) {
        case "addStudent":
            if (result) {
%>
                <p style="text-align: center;font-size: 30px;margin-top: 150px">添加学生成功！</p>
<%
            } else {
%>
                <p style="text-align: center;font-size: 30px;color: firebrick;margin-top: 150px">添加学生失败！</p>
                <p style="text-align: center;font-size: 30px;color: firebrick;">已存在学号相同学生！</p>
<%
            }
%>
            <p style="text-align: center"><a href="teacherHome.jsp">返回首页</a></p>
<%
            break;
        case "addHomework" :
            if (result) {
%>
                <p style="text-align: center;font-size: 30px;margin-top: 150px">布置作业成功！</p>
<%
            } else {
%>
                <p style="text-align: center;font-size: 30px;color: firebrick;margin-top: 150px">布置作业失败！</p>
                <p style="text-align: center;font-size: 30px;color: firebrick;">已存在编号相同作业！</p>
<%
            }
%>
            <p style="text-align: center"><a href="teacherHome.jsp">返回首页</a></p>
<%
            break;
        case "submitHomework":
            if (result) {
%>
            <p style="text-align: center;font-size: 30px;margin-top: 150px">提交作业成功！</p>
<%
            } else {
%>
            <p style="text-align: center;font-size: 30px;color: firebrick;margin-top: 150px">提交作业失败！</p>
<%
            }
%>
            <p style="text-align: center"><a href="studentHome.jsp">返回首页</a></p>
<%
            break;
        default:
%>
            <p style="text-align: center;font-size: 30px;color: firebrick;margin-top: 150px">发生未知错误！</p>
            <p style="text-align: center"><a href="index.jsp">返回首页</a></p>
<%
            break;
    }
%>


</body>

</html>