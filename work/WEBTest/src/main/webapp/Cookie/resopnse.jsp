<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/7/14
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //服务端
        Cookie cookie = new Cookie("name","lmd");
        Cookie cookie2 = new Cookie("pwd","123456");

        response.addCookie(cookie);
        response.addCookie(cookie2);


        //页面跳转到客户端（转发、重定向）
        response.sendRedirect("result.jsp");

    %>
</body>
</html>
