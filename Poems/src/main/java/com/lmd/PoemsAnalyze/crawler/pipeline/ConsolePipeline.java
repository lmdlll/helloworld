package com.lmd.PoemsAnalyze.crawler.pipeline;


import com.lmd.PoemsAnalyze.crawler.common.Page;

import java.util.Map;

public class ConsolePipeline implements Pipeline {

    @Override
    public void pipeline(Page page) {
        Map<String,Object> data = page.getDataSet().getData();

        //存储
        System.out.println(data);
    }
}
