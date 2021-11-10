package com.tws.springbootdemo.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.entity.Article;
import com.tws.springbootdemo.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/31 - 17:26
 */
@RequestMapping("/article")
@RestController
public class ArticleController {
    @Resource
    ArticleService articleService;
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public CommonResult getArticleByPage(@RequestBody PageInfo pageInfo) {
        PageInfo articles = articleService.getArticlesByPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return CommonResult.success(articles);
    }
    @RequestMapping(value = "/{aid}",method = RequestMethod.GET)
    public CommonResult getArticleById(@PathVariable Long aid) {
        Article article = articleService.getArticleById(aid);
        return CommonResult.success(article);
    }
    @RequestMapping(value = "/del", method = RequestMethod.PUT)
    public CommonResult deleteArticles(Long[] aids) {
        System.out.println(aids);
        int res = articleService.deleteArticleById(aids);
        if(res > 0) {
            return CommonResult.success(res);
        } else return CommonResult.failed("删除失败");
    }
    @RequestMapping(value = "/del/{aids}",method = RequestMethod.DELETE)
    public CommonResult deleteArticle(@PathVariable Long aids) {
        int res = articleService.deleteArticle(aids);
        if(res > 0) {
            return CommonResult.success(res);
        } else return CommonResult.failed("删除失败");
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CommonResult addNewArticle(@RequestBody  Article article) {
        int res = articleService.addNewArticle(article);
        if(res > 0) {
            return CommonResult.success(null);
        } else return CommonResult.failed("添加失败");
    }
}
