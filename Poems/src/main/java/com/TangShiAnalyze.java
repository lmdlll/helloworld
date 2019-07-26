package com;

import com.alibaba.druid.pool.DruidDataSource;
import com.lmd.PoemsAnalyze.analyze.dao.AnalyzeDAO;
import com.lmd.PoemsAnalyze.analyze.dao.impl.AnalyzeDaoImpl;
import com.lmd.PoemsAnalyze.config.ConfigProperties;
import com.lmd.PoemsAnalyze.crawler.Crawler;
import com.lmd.PoemsAnalyze.crawler.common.Page;
import com.lmd.PoemsAnalyze.crawler.pipeline.ConsolePipeline;
import com.lmd.PoemsAnalyze.crawler.pipeline.DatabasePipeline;
import com.lmd.PoemsAnalyze.crawler.prase.DataPageParse;
import com.lmd.PoemsAnalyze.crawler.prase.DocumentParse;

import javax.sql.DataSource;

/**
 * 这是唐诗分析的主类
 */

public class TangShiAnalyze {

    public static void main(String[] args) {
        System.out.println("这是唐诗分析的主类");

        ConfigProperties configProperties = new ConfigProperties();
        final Page page = new Page(
                configProperties.getCrawlerBase(),
                configProperties.getCrawlerPath(),
                configProperties.isCrawlerDetail());
        Crawler crawler = new Crawler();
        crawler.addParse(new DocumentParse());
        crawler.addParse(new DataPageParse());

//        crawler.addPipeline(new ConsolePipeline());
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(configProperties.getDbUsername());
        dataSource.setPassword(configProperties.getDbPassword());
        dataSource.setDriverClassName(configProperties.getDbDriverClass());
        dataSource.setUrl(configProperties.getDbUrl());


//        crawler.addPipeline(new DatabasePipeline(dataSource));
//        crawler.addPage(page);
//        crawler.start();

        AnalyzeDAO analyzeDAO = new AnalyzeDaoImpl(dataSource);
        System.out.println("测试一---------");
        analyzeDAO.analyzeAuthorCount().forEach(System.out::println);
        System.out.println("测试二-----------");
        analyzeDAO.queryAllPetry().forEach(System.out::println);

    }
}
