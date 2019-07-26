package com.lmd.PoemsAnalyze.analyze.service;

import com.lmd.PoemsAnalyze.analyze.model.AuthorCount;

import java.util.List;

public interface AnalyzeService {
    //分析唐诗中作者的创作数量
    List<AuthorCount> analyzeAuthorCount();

    //词云分析
    List<AuthorCount> analyzeWordCount();


}
