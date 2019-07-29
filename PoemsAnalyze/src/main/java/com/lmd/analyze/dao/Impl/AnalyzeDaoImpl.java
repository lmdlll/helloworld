package com.lmd.analyze.dao.Impl;

import com.lmd.analyze.dao.AnalyzeDao;
import com.lmd.analyze.entity.Poetry;
import com.lmd.analyze.model.AuthorCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AnalyzeDaoImpl implements AnalyzeDao {
    private final Logger logger = LoggerFactory.getLogger(AnalyzeDaoImpl.class);

    private final DataSource dataSource;

    public AnalyzeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        List<AuthorCount> datas = new ArrayList<>();
        //try()自动关闭
        String sql = "select count(*) as count , author from poetry group by author;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()){
                AuthorCount authorCount = new AuthorCount();
                authorCount.setAuthor(rs.getString("author"));
                authorCount.setCount(rs.getInt("count"));
                datas.add(authorCount);
            }
        } catch (SQLException e) {
            logger.error("Database query occur exception {}.",e.getMessage());
        }
        return datas;
    }

    @Override
    public List<Poetry> queryAllPoetryInfo() {
        List<Poetry> datas = new ArrayList<>();
        String sql ="select title, dynasty ,author, content from poetry;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()
        ){
            while (rs.next()){
                Poetry poetry = new Poetry();
                poetry.setTitle(rs.getString("title"));
                poetry.setDynasty(rs.getString("dynasty"));
                poetry.setAuthor(rs.getString("author"));
                poetry.setContent(rs.getString("content"));
                datas.add(poetry);
            }

        }catch (SQLException e){
            logger.error("Database query occur exception {}.",e.getMessage());
        }
        return datas;
    }
}
