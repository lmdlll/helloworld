package edu.greatfree.container.p2p.message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DELETRequset

class Main {

    public static void main(String[] args) throws Exception{



        Class.forName("com.mysql.jdbc.Driver");//加载驱动

        String url="jdbc:mysql:///studentinfo"; //连接字符串

        Connection con;
        con = DriverManager.getConnection(url,"root","sa");


        //执行添加语句

        String sql1="insert into student values(?,?,?)";

        PreparedStatement pst1=con.prepareStatement(sql1);
        int k =pst1.executeUpdate();

        System.out.println("ADDUSER");

        pst1.close();



        //执行修改语句

        String sql="Update student set sname= ?,sex= ? where sno= ?";//准备sql语句，？是占位符，内容待定

        PreparedStatement pst=con.prepareStatement(sql);//创建封装语句的对象


        pst.close();



        //执行删除语句

        String sql2="delete from student where sno=?";

        PreparedStatement pst2=con.prepareStatement(sql2);

        k = pst2.executeUpdate();

        System.out.println("删除完成");

        pst2.close();



        //查询某一个人

        System.out.println("DELETEuser");

        String sql4="select * from student where sno=?";

        PreparedStatement pst4=con.prepareStatement(sql4);

        pst4.setString(1,"20096786");

        ResultSet rs1=pst4.executeQuery();

        while(rs1.next()) {

            System.out.println(rs1.getString(1)+","+rs1.getString(2)+","+rs1.getString(3));

        }

        rs1.close();//关闭结果集

        pst4.close();//执行sql语句1



        //执行查询语句

        System.out.println("查询全部");

        String sql3="select * from student";

        PreparedStatement pst3=con.prepareStatement(sql3);

        ResultSet rs=pst3.executeQuery();

        while(rs.next()){

            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));//1,2,3分别代表第1,2,3列

        }

        rs.close();

        pst3.close();
        con.close();//关闭连接





    }

}



