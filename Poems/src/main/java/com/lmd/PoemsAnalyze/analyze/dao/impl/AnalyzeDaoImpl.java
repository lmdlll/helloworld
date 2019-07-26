package com.lmd.PoemsAnalyze.analyze.dao.impl;

import com.lmd.PoemsAnalyze.analyze.dao.AnalyzeDAO;
import com.lmd.PoemsAnalyze.analyze.entity.Poetry;
import com.lmd.PoemsAnalyze.analyze.model.AuthorCount;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnalyzeDaoImpl implements AnalyzeDAO {

    private final DataSource dataSource;

    public AnalyzeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        List<AuthorCount> datas = new ArrayList<>();
        String sql = "select count(*) as count, author from poetry group by author;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet res = statement.executeQuery()) {
            while (res.next()){
                AuthorCount authorCount = new AuthorCount();
                authorCount.setAuthor(res.getString("author"));
                authorCount.setCount(res.getInt("count"));
                datas.add(authorCount);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return datas;
    }

    @Override
    public List<Poetry> queryAllPetry() {
        List<Poetry> datas = new ArrayList<>();
        String sql = "select title,dynasty,author,content from poetry;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet res = statement.executeQuery()) {
            while (res.next()){
                Poetry poetry = new Poetry();
                poetry.setTitle(res.getString("titlr"));
                poetry.setDynasty(res.getString("dynasty"));
                poetry.setAuthor(res.getString("author"));
                poetry.setContent(res.getString("content"));
                datas.add(poetry);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return datas;
    }
}


