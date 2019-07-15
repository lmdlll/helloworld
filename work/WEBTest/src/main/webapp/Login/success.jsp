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
//    String name = request.getParameter("uname");
//    out.print(name);

    //如果用户没有当了，而是直接通过地址栏访问welcome.jsp，则必然获取到name为null
    //如果没有登录，应该跳转登录页面
    String name = (String) session.getAttribute("uname");
    if(name!=null){
        out.print(name);
%>
    <a href="destory.jsp">注销</a>
<%
    }else {
        response.sendRedirect("login.jsp");
    }

%>

</body>
</html>
