package com.service;

import com.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询分类列表
     * @return 分类列表
     */
    List<Category> listCategory();
}
