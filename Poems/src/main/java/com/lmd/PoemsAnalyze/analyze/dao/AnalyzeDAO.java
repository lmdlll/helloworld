package com.lmd.PoemsAnalyze.analyze.dao;

import com.lmd.PoemsAnalyze.analyze.entity.Poetry;
import com.lmd.PoemsAnalyze.analyze.model.AuthorCount;

import java.util.List;

public interface AnalyzeDAO {
    //分析唐诗中作者做诗的数量
    List<AuthorCount> analyzeAuthorCount();

    //查询所以的诗文，提供给业务层进行分析
    List<Poetry> queryAllPetry();



}
