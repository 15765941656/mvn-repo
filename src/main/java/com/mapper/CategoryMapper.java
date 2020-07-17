package com.mapper;

import com.entity.Category;

import java.util.List;

public interface CategoryMapper {

    /**
     * 根据文章id,查询文章对应着哪些分类
     * @param articleId 文章id
     * @return 分类列表(实际上只有两条数据,父级分类,子级分类)
     */
    List<Category> listCategoryByArticleId(Integer articleId);

    /**
     * 查询分类列表
     * @return
     */
    List<Category> listCategory();

    /**
     * 根据父类级分类的id查询子级分类列表,暂时没用上,以后可能会用
     * @param parentId 父级分类
     * @return 子級分类列表
     */
    List<Category> listCategoryByParentId(Integer parentId);

}