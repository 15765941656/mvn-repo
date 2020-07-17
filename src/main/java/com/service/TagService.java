package com.service;

import com.entity.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询标签列表
     * @return 标签列表
     */
    public List<Tag> listTag();
}
