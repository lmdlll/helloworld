package com.lmd.crawler.parse;

import com.lmd.crawler.common.Page;

public interface Parse {
    /**
     * 解析页面
     */
    void parse(final Page page);
}
