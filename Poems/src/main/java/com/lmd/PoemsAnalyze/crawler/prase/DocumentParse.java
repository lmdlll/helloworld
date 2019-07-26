package com.lmd.PoemsAnalyze.crawler.prase;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lmd.PoemsAnalyze.crawler.common.Page;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


/**
 * 链接解析（及非详情页面的链接解析）
 */
public class DocumentParse implements Parse {
    @Override
    public void parse(Page page) {
        //如果是详情页，则退出链接解析
        if(page.isDetail()){
            return;
        }
        //因为lamda表达式，外部是被final修饰的，内部不能用int，所以用AtomicInteger
        final AtomicInteger count = new AtomicInteger(0);
        HtmlPage htmlPage = page.getHtmlPage();
        htmlPage.getBody()
                .getElementsByAttribute("div","class","typecont")
                .forEach(div -> {
//                        System.out.println(htmlElement.asXml()); //打印标题与作者
                    //获取超链接中的字---诗词名字
                    DomNodeList<HtmlElement> aNodeList = div.getElementsByTagName("a");
                    aNodeList.forEach(
                            aNode -> {
//                                System.out.println(aNode.asXml());
                                //取得当前页面的子页面地址
                                String path = aNode.getAttribute("href");
                                Page subpage = new Page(page.getBase(),path,true);
                                page.getSubPage().add(subpage);
                            }
                    );
                });


    }
}
