<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/7/14
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>

    登录成功！<br>
    欢迎用户：
<%
    String name = request.getParameter("uname");
    out.print(name);
%>

</body>
</html>
