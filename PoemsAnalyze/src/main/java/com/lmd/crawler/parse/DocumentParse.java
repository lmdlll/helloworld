package com.lmd.crawler.parse;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lmd.crawler.common.Page;

//非详情页面的处理
public class DocumentParse implements Parse{

    @Override
    public void parse(final Page page) {
        //如果是详情页面，则直接退出
        if (page.isDetail()) {
            return;
        }
        HtmlPage htmlPage = page.getHtmlPage();
        htmlPage.getBody()
                .getElementsByAttribute("div", "class", "typecont")
                .forEach(div -> {
                    //这里得到超链接的地址
                    DomNodeList<HtmlElement> aNodeList = div.getElementsByTagName("a");
                    //根据超链接地址得到子页面数据
                    aNodeList.forEach(
                            aNode -> {
                                //得到子页面的具体地址
                                String subpath = aNode.getAttribute("href");
                                Page subPage = new Page(
                                        page.getBase(),
                                        subpath,
                                        true
                                );
                                //子页面添加
                                page.getSubPage().add(subPage);
                            }
                    );
                });
    }

}
