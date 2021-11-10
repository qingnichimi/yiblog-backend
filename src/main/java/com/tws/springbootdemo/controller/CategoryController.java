package com.tws.springbootdemo.controller;

import com.github.pagehelper.PageInfo;
import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.entity.Category;
import com.tws.springbootdemo.service.CategoryService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author taoweishu
 * @date 2021/11/4 - 11:23
 */
@RequestMapping("/category")
@RestController
public class CategoryController {
    @Resource
    CategoryService categoryService;
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public CommonResult getAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        return CommonResult.success(categoryList);
    }
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public CommonResult getCategoryByPage(@RequestBody PageInfo pageInfo) {
        PageInfo categoryList = categoryService.getAllCategoryByPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return CommonResult.success(categoryList);
    }
    @RequestMapping(value = "/del/{cids}",method = RequestMethod.DELETE)
    public CommonResult deleteCategory(@PathVariable Long cids) {
        int res = categoryService.deleteCategory(cids);
        if(res > 0) {
            return CommonResult.success(null);
        } else return CommonResult.failed("删除失败");
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CommonResult addCategory(@RequestBody Category category) {
        int res = categoryService.addCategory(category);
        if(res > 0) {
            return CommonResult.success(null);
        } else return CommonResult.failed("添加失败");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return CommonResult.success(category);
    }
}
