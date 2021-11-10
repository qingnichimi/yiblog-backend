package com.tws.springbootdemo.mapper;

import com.tws.springbootdemo.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author taoweishu
 * @date 2021/11/4 - 11:19
 */
@Mapper
public interface CategoryMapper {
    List<Category> getAllCategory();
    int deleteCategory(Long cids);
    int addCategory(Category category);
    Category getCategoryById(Long id);
}
