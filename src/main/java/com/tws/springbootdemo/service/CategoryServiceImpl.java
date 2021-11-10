package com.tws.springbootdemo.service;

import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tws.springbootdemo.entity.Category;
import com.tws.springbootdemo.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author taoweishu
 * @date 2021/11/4 - 11:22
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryMapper.getAllCategory();
        return categoryList;
    }

    @Override
    public PageInfo getAllCategoryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Category> categoryList = categoryMapper.getAllCategory();
        PageInfo pageInfo = new PageInfo(categoryList);
        return pageInfo;
    }

    @Override
    public int deleteCategory(Long cids) {
        int res = categoryMapper.deleteCategory(cids);
        return res;
    }

    @Override
    public int addCategory(Category category) {
        if(category.getCreate_time() == null) {
            category.setCreate_time(new DateTime());
        }
        int res = categoryMapper.addCategory(category);
        return res;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryMapper.getCategoryById(id);
        return category;
    }
}
