package com.lmd.PoemsAnalyze.crawler.common;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Page {
    //数据网站的根地址 eg：https://so.gushiwen.org
    private String base;

    //具体网页的路径  eg: /shiwenv_45c396367f59.aspx
    private String path;

    //网页的DOM对象
    private HtmlPage htmlPage;

    //标识网页是否是详情页
    private boolean detail;
    //如果不是详情页，还有子页面
    //子页面对象集合
    private Set<Page> subPage = new HashSet<>();

    //数据对象
    private DataSet dataSet = new DataSet();


    //获得具体的网址
    public String getUrl(){
        return this.base+this.path;
    }

}
