package com.service;

import com.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
    List<Article> listRecentArticle(Integer n);

    PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);

    void addArticle(Article article);
}
