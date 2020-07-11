package com.mapper;

import com.entity.Article;

import java.util.List;

public interface ArticleMapper {
    /**
     * 查询前n条文章
     * @param n  要查出来的文章数
     * @return 文章列表
     */
    List<Article> listRecentArticle(Integer n);

    Article getArticleById(Integer id);
}
