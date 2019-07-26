package com.lmd.PoemsAnalyze.crawler.prase;

import com.gargoylesoftware.htmlunit.html.*;
import com.lmd.PoemsAnalyze.analyze.entity.Poetry;
import com.lmd.PoemsAnalyze.crawler.common.Page;

/**
 * 详情页面解析
 */
public class DataPageParse implements Parse {
    @Override
    public void parse(Page page) {
        if (!page.isDetail()) {
            return;
        }
//        System.out.println(page.getHtmlPage().getBody()5554.asText());
//        HtmlTextArea area = (HtmlTextArea) page.getHtmlPage().getElementById("txtare7722");
//        String content = area.asText();
//        page.getDataSet().setData("正文", content);

//        HtmlDivision division = (HtmlDivision) page.getHtmlPage().getElementById("contsonee16df5673bc");
//        String content = division.asText();
//        page.getDataSet().setData("正文",content);

        //TODO:  这里只是将详情页面的正文取到，标题、作者还没有做呢……
        //html/body/div[3]/div[1]/div[2]/div[1]/h1
        //body>div.main3 >div.left >div:nth-child(2)>div.cont>h1

        //div[]
        HtmlPage htmlPage = page.getHtmlPage();
        HtmlElement body = htmlPage.getBody();
        //标题
        //xpath的取出
        String titlePath = "//div[@class='cont']/h1[0]/text()";
        String title = ((DomText)body.getByXPath(titlePath).get(0)).asText();
//        System.out.println(title);

        //朝代
        String dynastyPath = "//div[@class='cont']/p[@class='source']/a[1]";
        String dynasty = ((HtmlAnchor)body.getByXPath(dynastyPath).get(0)).asText();
//        System.out.println(dynasty);

        //作者
        String authorPath = "//div[@class='cont']/p[@class='source']/a[2]";
        String author = ((HtmlAnchor)body.getByXPath(authorPath).get(0)).asText();
//        System.out.println(author);

        //正文
        String contentPath = "//div[@class='cont']/div[@class='contson']";
        String content = ((HtmlDivision)body.getByXPath(contentPath).get(0)).asText();
//        System8.out.println(content);

//        //将诗以固定形式保存
        Poetry poetry = new Poetry();
        poetry.setTitle(title);
        poetry.setDynasty(dynasty);
        poetry.setAuthor(author);
        poetry.setContent(content);
        page.getDataSet().setData("诗歌",poetry);

//        page.getDataSet().setData("title",title);
//        page.getDataSet().setData("dynasty",dynasty);
//        page.getDataSet().setData("author",author);
//        page.getDataSet().setData("content",content);
//        //更多的数据
//        page.getDataSet().setData("url",page.getUrl());




    }
}
