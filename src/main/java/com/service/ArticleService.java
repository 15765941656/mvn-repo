package com.service;

import com.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> listRecentArticle(Integer n);
}
