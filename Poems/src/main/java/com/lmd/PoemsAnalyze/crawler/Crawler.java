package com.lmd.PoemsAnalyze.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lmd.PoemsAnalyze.crawler.common.Page;
import com.lmd.PoemsAnalyze.crawler.pipeline.ConsolePipeline;
import com.lmd.PoemsAnalyze.crawler.pipeline.Pipeline;
import com.lmd.PoemsAnalyze.crawler.prase.DataPageParse;
import com.lmd.PoemsAnalyze.crawler.prase.DocumentParse;
import com.lmd.PoemsAnalyze.crawler.prase.Parse;

import java.io.IOException;

public class Crawler {
    public static void main(String[] args) throws IOException {
        final Page page = new Page();
        page.setBase("https://so.gushiwen.org");
//        page.setPath("/shiwenv_ee16df5673bc.aspx");
//        page.setDetail(true);  //这是一详情页面
        //非详情页面
        page.setPath("/gushi/tangshi.aspx");
        page.setDetail(false);

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage htmlPage = webClient.getPage(page.getUrl());
        page.setHtmlPage(htmlPage);

//        Parse parse = new DataPageParse();
//        parse.parse(page);
//        Pipeline pipeline = new ConsolePipeline();
//        pipeline.pipeline(page);
        Parse parse = new DocumentParse();
        parse.parse(page);

    }
}
