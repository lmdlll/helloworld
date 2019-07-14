<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/7/14
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单登录</title>
</head>
<body>
<%!
    String uname;
%>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie:cookies){
        if(cookie.getName().equals("uname")){
            uname = cookie.getValue();
        }
    }
%>
    <form action="check.jsp" method="post">
        用户名：<input type="text" name="uname" value="<%=(uname==null?"":uname)%>"><br/>
        密码：<input type="password" name="upwd"><br>
        <input type="submit" value="提交"><br>

    </form>

</body>
</html>
