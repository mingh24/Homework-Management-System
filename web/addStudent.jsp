<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/12
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-添加学生</title>
</head>

<body>
<h1 style="text-align: center;margin-top: 100px;margin-bottom: 50px">输入学生信息</h1>
<div align="center">
    <form action="${pageContext.request.contextPath}/addStudent" method="post">
        <table style="border-collapse:separate;border-spacing:0 20px;">
            <tr>
                <th>学号：</th>
                <td>
                    <label>
                        <input type="number" name="id" maxlength="20" required>
                    </label>
                </td>
            </tr>
            <tr>
                <th>姓名：</th>
                <td>
                    <label>
                        <input type="text" name="name" maxlength="20" required>
                    </label>
                </td>
            </tr>
        </table>

        <input type="reset" value="清空" style="width: 100px;margin-top: 50px;margin-right: 50px">
        <input type="submit" value="提交" style="width: 100px;margin-left: 50px">
    </form>

    <p style="text-align: center;margin-top: 50px"><a href="teacherHome.jsp">返回首页</a></p>
</div>
</body>

</html>
