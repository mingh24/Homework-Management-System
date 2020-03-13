<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/12
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-布置作业</title>
</head>

<body>
<h1 style="text-align: center;margin-top: 100px;margin-bottom: 50px">输入作业信息</h1>
<div align="center">
    <form action="${pageContext.request.contextPath}/addHomework" method="post">
        <table style="border-collapse:separate;border-spacing:10px 20px;">
            <tr>
                <th>作业标题：</th>
                <td>
                    <label>
                        <input type="text" name="title" maxlength="40" required>
                    </label>
                </td>
            </tr>
            <tr>
                <th>作业内容：</th>
                <td>
                    <label>
                        <textarea name="content" rows="10" cols="40" required></textarea>
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
