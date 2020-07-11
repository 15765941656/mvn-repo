package com.service.impl;

import com.entity.Article;
import com.entity.Comment;
import com.mapper.ArticleMapper;
import com.mapper.CommentMapper;
import com.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private ArticleMapper articleMapper;

    public List<Comment> listRecentComment(Integer n) {
        List<Comment>commentList = commentMapper.listRecentComment(n);
        for(Comment c: commentList){
            Article article = articleMapper.getArticleById(c.getCommentArticleId());
            c.setArticle(article);
        }
        return commentList;
    }
}