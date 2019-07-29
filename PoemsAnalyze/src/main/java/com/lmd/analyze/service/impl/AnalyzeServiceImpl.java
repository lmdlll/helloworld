package com.lmd.analyze.service.impl;

import com.lmd.analyze.dao.AnalyzeDao;
import com.lmd.analyze.entity.Poetry;
import com.lmd.analyze.model.AuthorCount;
import com.lmd.analyze.model.WordCount;
import com.lmd.analyze.service.AnalyzeService;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.*;

public class AnalyzeServiceImpl  implements AnalyzeService {
    private final AnalyzeDao analyzeDao;

    public AnalyzeServiceImpl(AnalyzeDao analyzeDao) {
        this.analyzeDao = analyzeDao;
    }

    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        //此处结果并未排序
        List<AuthorCount> authorCounts = analyzeDao.analyzeAuthorCount();
        //此处是按照count降序
        authorCounts.sort((o1, o2) -> (-1)*o1.getCount().compareTo(o2.getCount()));
//        authorCounts.sort(Comparator.comparing(AuthorCount::getCount)); 升序
        return authorCounts;
    }

    @Override
    public List<WordCount> analyzeWordCount() {
        //1.查询出所有的数据
        //2.取出 title content
        //3.分词 过滤 /w  null 空  len<2
        //4.统计 k-v  k是词 v是词频
        Map<String, Integer> map = new HashMap<>();
        List<Poetry> poetryInfos = analyzeDao.queryAllPoetryInfo();
        for (Poetry poetryInfo : poetryInfos) {
            List<Term> terms = new ArrayList<>();
            String title = poetryInfo.getTitle();
            String content = poetryInfo.getContent();
            //NlpAnalysis：中文分词
            terms.addAll(NlpAnalysis.parse(title).getTerms());
            terms.addAll(NlpAnalysis.parse(content).getTerms());
            Iterator<Term> iterator = terms.iterator();
            while (iterator.hasNext()) {
                Term term = iterator.next();
                //词性的过滤  w是数字标点符号
                if (term.getNatureStr() == null || term.getNatureStr().equals("w")) {
                    iterator.remove();
                    continue;
                }
                //词的过滤 起码大于2个字
                if (term.getRealName().length() < 2) {
                    iterator.remove();
                    continue;
                }
                //统计
                String moreword = term.getRealName();
                int count;
                if (map.containsKey(moreword)) {
                    count = map.get(moreword) + 1;
                } else {
                    count = 1;
                }
                map.put(moreword, count);
            }
        }
        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordCount wordCount = new WordCount();
            wordCount.setCount(entry.getValue());
            wordCount.setWord(entry.getKey());
            wordCounts.add(wordCount);
        }
        return wordCounts;
    }
}
