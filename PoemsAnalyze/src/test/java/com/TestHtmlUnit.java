package com;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class TestHtmlUnit {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage htmlPage = null;
        try {
            htmlPage = webClient.getPage("https://www.gushiwen.org");
            String content = htmlPage.asText();
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
