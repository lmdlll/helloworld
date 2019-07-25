package com.lmd.PoemsAnalyze.crawler.prase;

import com.gargoylesoftware.htmlunit.html.HtmlArea;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
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

        HtmlDivision division = (HtmlDivision) page.getHtmlPage().getElementById("contsonee16df5673bc");
        String content = division.asText();
        page.getDataSet().setData("正文",content);
        //TODO:  这里只是将详情页面的正文取到，标题、作者都没有做呢……

    }
}
