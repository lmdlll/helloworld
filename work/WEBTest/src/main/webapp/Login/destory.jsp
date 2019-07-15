<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/7/15
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号注销</title>
</head>
<body>
    <%
        //将全部的session都注销
        session.invalidate();
//        //注销部分
//        session.removeAttribute("uname");
    %>

</body>
</html>
