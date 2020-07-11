package com.service.impl;

import com.entity.Article;
import com.mapper.ArticleMapper;
import com.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Resource
    private ArticleMapper articleMapper;

    public List<Article> listRecentArticle(Integer n) {
        return articleMapper.listRecentArticle(n);
    }
}
