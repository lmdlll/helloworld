package com.lmd.crawler.pipeline;


import com.lmd.crawler.common.Page;

import java.util.Map;

public class ConsolePipeline  implements Pipeline {
    @Override
    public void pipeline(final Page page) {
        Map<String, Object> data = page.getDataSet().getData();
        System.out.println(data);
    }
}
