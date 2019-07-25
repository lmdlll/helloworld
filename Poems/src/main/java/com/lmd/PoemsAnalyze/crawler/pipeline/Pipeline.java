package com.lmd.PoemsAnalyze.crawler.pipeline;

import com.lmd.PoemsAnalyze.crawler.common.Page;

public interface Pipeline {
    void pipeline(Page page);
}
