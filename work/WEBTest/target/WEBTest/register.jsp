<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/7/13
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form action="show.jsp">
        用户名：<input type="text" name="uname" value="张三"/><br/>
        密码：<input type="password" name="upwd"/><br/>
        年龄：<input type="text" name="uage"/><br/>
        爱好：<br/>
            <input type="checkbox" name="uhobbies" value="足球"/>足球
            <input type="checkbox" name="uhobbies" value="舞蹈"/>舞蹈
            <input type="checkbox" name="uhobbies" value="跑步"/>跑步
            <input type="checkbox" name="uhobbies" value="游泳"/>游泳<br/>
        <input type="submit" value="注册">

    </form>

</body>
</html>
