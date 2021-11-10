package com.tws.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.tws.springbootdemo.entity.Category;

import java.util.List;

/**
 * @author taoweishu
 * @date 2021/11/4 - 11:22
 */
public interface CategoryService {
    List<Category> getAllCategory();
    PageInfo getAllCategoryByPage(int pageNum, int pageSize);
    int deleteCategory(Long cids);
    int addCategory(Category category);
    Category getCategoryById(Long id);
}
