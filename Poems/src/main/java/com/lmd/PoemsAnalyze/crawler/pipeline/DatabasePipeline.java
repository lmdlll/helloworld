package com.lmd.PoemsAnalyze.crawler.pipeline;

import com.lmd.PoemsAnalyze.crawler.common.Page;
import com.lmd.PoemsAnalyze.analyze.entity.Poetry;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePipeline implements Pipeline{

    private final DataSource dataSource;

    public DatabasePipeline(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void pipeline(Page page) {
//        Poetry poetry = (Poetry) page.getDataSet().getData("诗歌");
//        System.out.println("存储到数据库"+poetry);

        Poetry poetry = new Poetry();
        String title = (String) page.getDataSet().getData("title");
        String dynasty = (String) page.getDataSet().getData("dynasty");
        String author = (String) page.getDataSet().getData("author");
        String content = (String) page.getDataSet().getData("content");


        //修改对象

        String sql = "insert into poerty(title, dynasty, author, content) values (?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1,title);
            statement.setString(2,dynasty);
            statement.setString(3,author);
            statement.setString(4,content);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
