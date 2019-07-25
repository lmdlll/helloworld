package com.lmd.PoemsAnalyze.crawler.prase;

import com.lmd.PoemsAnalyze.crawler.common.Page;

public interface Parse {
    /**
     * 解析页面
     * @param page
     */
    void parse(Page page);
}
