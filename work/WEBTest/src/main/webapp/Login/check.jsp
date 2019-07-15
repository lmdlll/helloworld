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
    <title>表单验证</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");

//        //将用户名加入到cookie中
//        Cookie cookie = new Cookie("name",name);
//        response.addCookie(cookie);
//
//        response.sendRedirect("success.jsp");



        //验证用户名与密码是否正确
        if(name.equals("lmd")&&pwd.equals("123456")){
//            response.sendRedirect("success.jsp");//重定向会导致数据丢失
            //页面跳转，请求转发，可以获取到数据，并且地址栏没有改变（仍然保留转发时页面）
//            request.getRequestDispatcher("success.jsp").forward(request,response);

            //只有登录成功，session才会存在uname，upwd
            session.setAttribute("uname",name);
            session.setAttribute("upwd",pwd);
            request.getRequestDispatcher("success.jsp");

        }else {
            //登录失败
            response.sendRedirect("login.jsp");
            out.print("用户名或密码有误");
        }

    %>

</body>
</html>
