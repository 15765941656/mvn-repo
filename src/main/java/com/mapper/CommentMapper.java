package com.mapper;

import com.entity.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     * 查询最近的n条评论
     * @param n 条数
     * @return  列表
     */
    List<Comment> listRecentComment(Integer n);
}
