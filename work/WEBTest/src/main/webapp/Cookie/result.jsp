<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/7/14
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //获取cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            out.print(cookie.getName()+":"+cookie.getValue()+"<br>");
        }
    %>

</body>
</html>
