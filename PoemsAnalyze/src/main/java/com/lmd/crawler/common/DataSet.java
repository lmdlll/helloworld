package com.lmd.crawler.common;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储清洗的数据
 */
@ToString
public class DataSet {
    /**
     * data把DOM（Document Object Model）解析，清洗之后存储的数据
     * 比如：
     * 标题：XXXX
     * 作者：李白
     * 正文: XXX
     */
    private Map<String, Object> data = new HashMap<>();

    public void putData(String key, Object value) {
        this.data.put(key, value);
    }

    public Object getData(String key) {
        return this.data.get(key);
    }

    public Map<String, Object> getData() {
        //防止将引用交给他人，避免不需要的改动，所以new一个对象过去，只是将值传输而非引用
        return new HashMap<>(this.data);
    }
}
