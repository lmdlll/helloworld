package com.lmd;

import com.alibaba.druid.pool.DruidDataSource;
import com.lmd.analyze.dao.AnalyzeDao;
import com.lmd.analyze.dao.Impl.AnalyzeDaoImpl;
import com.lmd.analyze.model.AuthorCount;
import com.lmd.config.ConfigProperties;
import com.lmd.config.ObjectFactory;
import com.lmd.crawler.Crawler;
import com.lmd.crawler.common.Page;
import com.lmd.crawler.parse.DataPageParse;
import com.lmd.crawler.parse.DocumentParse;
import com.lmd.web.WebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.util.function.Consumer;


public class TangshiAnalyze {
    private static final Logger LOGGER = LoggerFactory.getLogger(TangshiAnalyze.class);

    public static void main(String[] args) {
//        ConfigProperties configProperties = new ConfigProperties();
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername(configProperties.getDbUsername());
//        dataSource.setPassword(configProperties.getDbPassword());
//        dataSource.setUrl(configProperties.getDbUrl());
//        dataSource.setDriverClassName(configProperties.getDbDriverClass());
//        AnalyzeDao analyzeDao = new AnalyzeDaoImpl(dataSource);
//        System.out.println("测试一：");
//        analyzeDao.analyzeAuthorCount().forEach(System.out::println);
//        System.out.println("测试二：");
//        analyzeDao.queryAllPoetryInfo().forEach(System.out::println);

//        Spark.get("/hello", (req, res) -> "Hello World");
        Spark.get("/hello", (req, res) -> "Hello World");


//        WebController webController = ObjectFactory.getInstance().getObject(WebController.class);
//        //运行了web服务，提供接口
//        LOGGER.info("Web Server launch ...");
//        webController.launch();
//
//        //启动爬虫
//        if (args.length == 1 && args[0].equals("start-crawler")) {
//            Crawler crawler = ObjectFactory.getInstance().getObject(Crawler.class);
//            LOGGER.info("Crawler started ...");
//            crawler.start();
//        }

        //127.0.0.1:4567/index.html
    }
}
