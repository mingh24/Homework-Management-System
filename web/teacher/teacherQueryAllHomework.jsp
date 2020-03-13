<%@ page import="com.java.code.model.Homework" %>
<%@ page import="com.java.code.jdbc.DatabaseManager" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: yipple
  Date: 2020/3/13
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-作业列表</title>
    <script>
        function sendHomeworkId(specifiedHomeworkId) {
            document.getElementById("hiddenRecorder").setAttribute("value", specifiedHomeworkId);
            document.getElementById("homeworkForm").submit();
        }
    </script>
</head>

<body>
<form id="homeworkForm" action="${pageContext.request.contextPath}/teacher/viewSubmittedSpecifiedHomeworkDetails" method="get">
    <table align="center" width="960" border="1"
           bgcolor="black" cellpadding="1" cellspacing="1">
        <tr align="center" bgcolor="#63B8FF" height="50">
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
            <td></td>
        </tr>
        <%
            List<Homework> homeworkList = DatabaseManager.queryAllHomework();
            if (null == homeworkList || homeworkList.size() <= 0) {
        %>
        <p style="text-align: center">无相关记录</p>
        <%
        } else {
            for (Homework homework : homeworkList) {
        %>
        <tr align="center" bgcolor="white" height="30">
            <td>
                <%=homework.getId()%>
            </td>
            <td>
                <%=homework.getTitle()%>
            </td>
            <td>
                <%=homework.getContent()%>
            </td>
            <td>
                <%=homework.getCreateTime()%>
            </td>
            <td>
                <input type="button" value="查看详情" onclick="sendHomeworkId(<%=homework.getId()%>)">
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <input type="hidden" id="hiddenRecorder" name="specifiedHomeworkId">
</form>
<p style="text-align: center;margin-top: 50px"><a href="../student/studentHome.jsp">返回首页</a></p>
</body>

</html>
