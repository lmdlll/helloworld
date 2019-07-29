package com.lmd.analyze.service;

import com.lmd.analyze.model.AuthorCount;
import com.lmd.analyze.model.WordCount;

import java.util.List;

public interface AnalyzeService {
    // 分析唐诗中作者的创作数量
    List<AuthorCount> analyzeAuthorCount();

    //词云分析
    List<WordCount> analyzeWordCount();
}
