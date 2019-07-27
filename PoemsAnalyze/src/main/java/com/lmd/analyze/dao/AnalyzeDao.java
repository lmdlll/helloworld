package com.lmd.analyze.dao;

import com.lmd.analyze.entity.Poetry;
import com.lmd.analyze.model.AuthorCount;

import java.util.List;

public interface AnalyzeDao {
    /**
     * 分析唐诗中作者的创作数量
     *
     * @return
     */
    List<AuthorCount> analyzeAuthorCount();


    /**
     * 查询所有的诗文，提供给业务层进行分析
     *
     * @return
     */
    List<Poetry> queryAllPoetryInfo();
}
