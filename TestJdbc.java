package com.lmd;

import java.sql.*;
import java.time.LocalDateTime;

public class TestJdbc {

    public static void main(String[] args) {
        //为什么这里搜索不到mysql驱动？ --因为mysql-connector-java不在classpath

        //1.加载驱动程序     备注：5.1之后可以不明确加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.连接数据库
        //关于数据库连接的URL格式JDBC规范里也有定义
        //jdbc:database://host:port/databaseName?p1=v1 &p2=v2
        //jdbc:mysql://localhost:3306/memo?user=root&password=123lmd
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memo?user=root&password=123lmd&useSSL=true1a");
                //    "jdbc:mysql://localhost:3306/memo?user=root&password=123lmd"
            //3.创建命令
            Statement statement = connection.createStatement();

            //4.准备SQL，并执行
            ResultSet resultSet = statement.executeQuery("select id,name,created_time,modify_time from memo_group");

            //5.返回结果集，处理结果
            while(resultSet.next()){ //如果返回true表示有下一行记录，否则无记录
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createtime = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifytime = resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(
                        String.format("编号：%d，名称：%s，创建时间：%s，修改时间：%s",
                                id,name,createtime.toString(),modifytime.toString())
                );
            }
            //6.关闭结果集
            resultSet.close();

            //7.关闭命令
            statement.close();

            //8.关闭连接
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
