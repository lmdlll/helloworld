package com.lmd.crawler.parse;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lmd.crawler.common.Page;

public class DocumentParse implements Parse{

    @Override
    public void parse(final Page page) {
        if (page.isDetail()) {
            return;
        }
        HtmlPage htmlPage = page.getHtmlPage();
        htmlPage.getBody()
                .getElementsByAttribute("div", "class", "typecont")
                .forEach(div -> {
                    DomNodeList<HtmlElement> aNodeList = div.getElementsByTagName("a");
                    aNodeList.forEach(
                            aNode -> {
                                String path = aNode.getAttribute("href");
                                Page subPage = new Page(
                                        page.getBase(),
                                        path,
                                        true
                                );
                                page.getSubPage().add(subPage);
                            }
                    );
                });
    }

}
