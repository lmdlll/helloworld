package com.lmd;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class TestHtmlUnit {
    public static void main(String[] args) {
        try (WebClient webClient = new WebClient(BrowserVersion.CHROME)){
            webClient.getOptions().setJavaScriptEnabled(false);
            HtmlPage htmlPage = webClient.getPage("https://www.gushiwen.org/index.aspx");
            HtmlDivision division = (HtmlDivision) htmlPage.getElementById("contson1f45e6942780");
            String body = division.asXml();
            System.out.println(body);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
