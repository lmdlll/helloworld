package com.lmd.crawler.pipeline;

import com.lmd.crawler.common.Page;

public interface Pipeline {
    /**
     * 管道处理page中的数据
     *
     * @param page
     */
    void pipeline(final Page page);
}
