package com.service.impl;

import com.entity.Comment;
import com.mapper.CommentMapper;
import com.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    public List<Comment> listRecentComment(Integer n) {
        return commentMapper.listRecentComment(n);
    }
}