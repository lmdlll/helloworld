package com.lmd.PoemsAnalyze.crawler.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储清洗的数据
 */
public class DataSet {

    /**
     * data把DOM解析，清洗之后 存储的数据
     * eg：
     * 标题：xxx
     * 作者：李白
     * 正文：xxxxxxx
     */
    private Map<String,Object> data = new HashMap<>();

    public void setData(String key, Object value){
        data.put(key,value);
    }

    public Object getData(String key){
        return this.data.get(key);
    }

    public Map<String,Object> getData(){
// 不能直接return this.data  这样会将data的引用交给别人，不安全，因此重新创建一个map将数据输入即可，不用担心数据被破坏
        return new HashMap<>(this.data);
    }

}
