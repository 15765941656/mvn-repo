package com.mapper;

import com.entity.Tag;

import java.util.List;

public interface TagMapper {
    /**
     * 查询标签列表
     * @return 标签列表
     */
    public List<Tag> listTag();
}
