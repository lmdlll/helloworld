package com.lmd.PoemsAnalyze.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lmd.PoemsAnalyze.crawler.common.Page;
import com.lmd.PoemsAnalyze.crawler.pipeline.ConsolePipeline;
import com.lmd.PoemsAnalyze.crawler.pipeline.DatabasePipeline;
import com.lmd.PoemsAnalyze.crawler.pipeline.Pipeline;
import com.lmd.PoemsAnalyze.crawler.prase.DataPageParse;
import com.lmd.PoemsAnalyze.crawler.prase.DocumentParse;
import com.lmd.PoemsAnalyze.crawler.prase.Parse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 爬取的网页可以分为详情网页和还有子界面的非详情网页
 */
public class Crawler {

    //放置文档页面（超链接）
    //未被采集和解析的页面
    private final Queue<Page> docQueue = new LinkedBlockingDeque<>();

    //放置详情页面
    //处理完成、数据在dataSet中
    private final Queue<Page> detailQueue = new LinkedBlockingDeque<>();

    //采集器
    private final WebClient webClient;

    //所有的解析器
    private final List<Parse> parseList = new LinkedList<>();

    //所有的清洗器（管道）
    private final List<Pipeline> pipelineList = new LinkedList<>();

    //线程调度器
    private final ExecutorService executorService;

    public Crawler(){
        this.webClient = new WebClient(BrowserVersion.CHROME);
        this.webClient.getOptions().setJavaScriptEnabled(false);
        this.executorService = Executors.newFixedThreadPool(8, new ThreadFactory() {
            private final AtomicInteger id = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Crawler-Thread-"+id.getAndIncrement());
                return thread;
            }
        });

    }

    public void start(){
        //爬取
        //解析
        //清洗
        this.executorService.submit(this::parse);
        this.executorService.submit(this::pipeline);
    }

    //清洗
    private void pipeline() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final Page page = this.detailQueue.poll();
            if(page==null){
                continue;
            }
            for(Pipeline pipeline:Crawler.this.pipelineList){
                pipeline.pipeline(page);
            }
//            this.executorService.submit(() -> {
//                for(Pipeline pipeline:Crawler.this.pipelineList){
//                    pipeline.pipeline(page);
//                }
//            });

        }
    }

    //解析
    private void parse() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final Page page = this.docQueue.poll();
            if(page==null){
                continue;
            }
            this.executorService.submit(() -> {
                try {
                    //采集
                    HtmlPage htmlPage = Crawler.this.webClient.getPage(page.getUrl());
                    page.setHtmlPage(htmlPage);

                    for (Parse parse : Crawler.this.parseList) {
                        parse.parse(page);
                    }
                    if(page.isDetail()){
                        Crawler.this.detailQueue.add(page);
                    }else {
                        Iterator<Page> iterator = page.getSubPage().iterator();
                        while (iterator.hasNext()){
                            Page subpage = iterator.next();
                            System.out.println(subpage);
                            this.docQueue.add(subpage);
                            iterator.remove();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    public void addPage(Page page){
        this.docQueue.add(page);
    }

    public void addParse(Parse parse) {
        this.parseList.add(parse);
    }

    public void addPipeline(Pipeline pipeline){
        this.pipelineList.add(pipeline);
    }

    //停止爬虫
    public void stop(){
        if(this.executorService!=null && !this.executorService.isShutdown()){
            this.executorService.shutdown();
        }

    }



    public static void main(String[] args) throws IOException {
//        final Page page = new Page("https://so.gushiwen.org","/gushi/tangshi.aspx",false);
//        page.setBase("https://so.gushiwen.org");
        //这是一详情页面
//        page.setPath("/shiwenv_ee16df5673bc.aspx");
//        page.setDetail(true);
        //非详情页面
//        page.setPath("/gushi/tangshi.aspx");
//        page.setDetail(false);
//
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setJavaScriptEnabled(false);
//        HtmlPage htmlPage = webClient.getPage(page.getUrl());
//        page.setHtmlPage(htmlPage);

//        Parse parse = new DataPageParse();
//        parse.parse(page);
//        Pipeline pipeline = new ConsolePipeline();
//        pipeline.pipeline(page);
//
//        Parse parse = new DocumentParse();
//        parse.parse(page);

//        Queue<Page> detailPageList = new LinkedBlockingDeque<>();
//        List<Parse> parsesList = new LinkedList<>();
//        parsesList.add(new DocumentParse());
//        parsesList.add(new DataPageParse());
//        parsesList.forEach(parse -> {
//                    parse.parse(page);
//                    if (!page.isDetail()) {
//                        page.getSubPage();
//                    }
//                });
//        System.out.println(page.getSubPage());
//
//        List<Pipeline> pipelineList = new LinkedList<>();
//        pipelineList.add(new ConsolePipeline());



        final Page page = new Page("https://so.gushiwen.org","/gushi/tangshi.aspx",false);
        Crawler crawler = new Crawler();
        crawler.addParse(new DocumentParse());
        crawler.addParse(new DataPageParse());
        crawler.addPipeline(new ConsolePipeline());
        crawler.addPage(page);
        crawler.start();

        //TODO 没有显示正文，一致是超链接
    }


}
