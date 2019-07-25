package com.lmd.PoemsAnalyze.crawler.prase;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lmd.PoemsAnalyze.crawler.common.Page;

import java.util.function.Consumer;


/**
 * 链接解析（及非详情页面的链接解析）
 */
public class DocumentParse implements Parse {
    @Override
    public void parse(Page page) {
        if(page.isDetail()){
            return;
        }
        HtmlPage htmlPage = page.getHtmlPage();
        htmlPage.getBody()
                .getElementsByAttribute("div","class","typecont")
                .forEach(htmlElement -> {
//                        System.out.println(htmlElement.asText());
                    DomNodeList<HtmlElement> nodeList =htmlElement.getElementsByTagName("a");
                    nodeList.forEach(
                            aNode -> {
                                System.out.println(aNode.asXml());
                            }
                    );
                });

    }
}
