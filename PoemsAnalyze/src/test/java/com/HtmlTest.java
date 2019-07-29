package com;

import spark.Spark;

public class HtmlTest {
    public static void main(String[] args) {

        Spark.get("/hello", (req, res) -> "Hello World");

    }
}
