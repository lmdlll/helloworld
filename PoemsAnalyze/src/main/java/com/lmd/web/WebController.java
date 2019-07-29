package com.lmd.web;

import com.google.gson.Gson;
import com.lmd.analyze.model.AuthorCount;
import com.lmd.analyze.model.WordCount;
import com.lmd.analyze.service.AnalyzeService;
import com.lmd.config.ObjectFactory;
import com.lmd.crawler.Crawler;
import spark.ResponseTransformer;
import spark.Spark;

import java.util.List;

public class WebController {

    private final AnalyzeService analyzeService;

    public WebController(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }

    // ->  http://127.0.0.1:4567/
    // ->  /analyze/author_count
    private List<AuthorCount> analyzeAuthorCount() {
        return analyzeService.analyzeAuthorCount();
    }


    // ->  http://127.0.0.1:4567/
    // ->  /analyze/word_cloud
    private List<WordCount> analyzeWordCount() {
        return analyzeService.analyzeWordCount();
    }


    public void launch() {
        ResponseTransformer transformer = new JSONResponseTransformer();

        //src/main/resources/static
        //前端静态文件的目录
        Spark.staticFileLocation("/static");
        //服务端接口
        Spark.get("/analyze/author_count", ((request, response) -> analyzeAuthorCount()), transformer);

        Spark.get("/analyze/word_clount", ((request, response) -> analyzeWordCount()), transformer);

        Spark.get("/crawler/stop", ((request, response) -> {
            Crawler crawler = ObjectFactory.getInstance().getObject(Crawler.class);
            crawler.stop();
            return "爬虫停止";

        }));

    }

    public static class JSONResponseTransformer implements ResponseTransformer {

        //Object -> String
        private Gson gson = new Gson();

        @Override
        public String render(Object o) throws Exception {
            return gson.toJson(o);
        }
    }
}
